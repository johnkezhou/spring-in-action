package chapter5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"chapter5"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)})
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter{
        public WebPackage(){
            super(Pattern.compile("chapter5\\.controller"));
        }
    }
}
