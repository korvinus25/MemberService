package test.ncube.MemberService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.ncube.MemberService.util.ModelDtoConverter;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    ModelDtoConverter modelDtoConverter(){
        return new ModelDtoConverter();
    }

}
