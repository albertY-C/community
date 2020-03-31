package chaoimi.community.Provider;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ALiProvider {
    @Value("${aliyun.ufile.public-key}")
    private String publicKey;
    @Value("${aliyun.ufile.private-key}")
    private String privateKey;
}
