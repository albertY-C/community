function post() {
    // 这个地方实践证明是正确的的但是和小匠的不同
    let questionId = $("#question_id").val();
    let content = $("#comment_content").val();
    commentToTarget(questionId, 1, content);
}

function commentToTarget(targetId, type, content) {

    if (!content) {
        alert("不能回复空内容~~~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
                debugger;
            } else {
                if (response.code == 2003) {
                    let isAccept = confirm(response.message);
                    if (isAccept) {
                        window.open("https://github.com/login/oauth/authorize?client_id=daa25e3521055d2553c6&redirect_uri=http://localhost:8887/callback&scope=user&state=1")
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });

}

function comment(e) {
    let commentId = e.getAttribute("data-id");
    let content = $("#input-" + commentId).val();
    commentToTarget(commentId, 2, content);
}



// 展开二级评论
function collapseComments(e) {
    let id = e.getAttribute("data-id");
    let comments = $("#comment-" + id);
    // 获取一下二级评论的展开状态
    let collapse = e.getAttribute("data-collapse");
    if (collapse) {
        // 折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        let subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            // 展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {

                    let mediaLeftElement = $("<div/>",{
                        "class":"media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    let mediaBodyElement = $("<div/>",{
                        "class":"media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class":"menu",
                    }).append($("<span/>", {
                        "class":"pull-right",
                        "html":moment(comment.gmtCreate).format('YYYY-MM-DD HH:MM')
                    })));

                    let mediaElement = $("<div/>",{
                        "class":"media"}).append(mediaLeftElement).append(mediaBodyElement);

                    let commentElement = $("<div/>",{
                        "class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"}).append(mediaElement);
                    subCommentContainer.prepend(commentElement);
                });
                // 展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }
    }
}
