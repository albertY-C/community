package chaoimi.community.cache;

import chaoimi.community.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagCache {
    public static List<TagDTO> get(){
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("java","php","css","html","html5","javascript","node.js","python","C ++","C","golang","objective","typescript","shell","swift","c#","sass","ruby","bash","less","lua","scala","coffeescript","actionscript","rust","erlang","perl"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel","spring","django","flask","yii","ruby-on-rails","koa","struts"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("Linux","docker","apache","ubuntu","tomact","unix","hadoop","windows"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","oracle","nosql","memcached","sqlserver","postgresql","sqlite"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git","github","visual-stdio","vim","subline","xcode","intellij-idea","eclipse","maven","ide","svn","hg","atom","textmate"
        ));
        tagDTOS.add(tool);

        return tagDTOS;
    }


}



