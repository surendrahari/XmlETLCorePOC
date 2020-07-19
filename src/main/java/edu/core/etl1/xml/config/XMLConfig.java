package edu.core.etl1.xml.config;

import edu.core.etl1.common.*;
import edu.core.etl1.xml.action.*;
import edu.core.etl1.xml.model.source.XMLSource;
import edu.core.etl1.xml.model.target.XMLTarget;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
public class XMLConfig {

    @Bean
    public Validator<String, String> preParserValidator() {
        System.out.println("preParserValidator init.......");
        return new XMLPreValidator();
    }

    @Bean
    public Parser<String, String, XMLSource> parser() {
        System.out.println("parser init.......");
        return new XMLParser();
    }

    @Bean
    public Validator<String, XMLSource> postParserValidator() {
        System.out.println("postParseValidator init.......");
        return new XMLValidator();
    }

    @Bean
    public Convertor<String, XMLSource, XMLTarget> convertor() {
        System.out.println("convertor init.......");
        return new XMLConverter();
    }

    @Bean
    public Enricher<String, XMLTarget> enricher() {
        System.out.println("enricher init.......");
        return new XMLEnricher();
    }

    @Bean
    public Poster<String, XMLTarget> poster() {
        System.out.println("poster init.......");
        return new XMLPoster();
    }

    @Bean
    public Processor<String, String, XMLTarget> processor() {
        System.out.println("processor init.......");

        return new XMLProcessor();
        /*final Validator<String, String> preParserValidator = preParserValidator();
        final Parser<String, String, XMLSource> parser = parser();
        final Validator<String, XMLSource> postParserValidator = postParserValidator();
        final Convertor<String, XMLSource, XMLTarget> convertor = convertor();
        final Enricher<String, XMLTarget> enricher = enricher();
        final Poster<String, XMLTarget> poster = poster();

        return (header, message) -> {
            Predicate<String> preParseValidate = (msg) -> preParserValidator.validate(header, msg);
            Function<String, XMLSource> parse = (msg) -> parser.parse(header, msg);
            Predicate<XMLSource> postParseValidate = (src) -> postParserValidator.validate(header, src);
            Function<XMLSource, XMLTarget> convert = (src) -> convertor.convert(header, src);
            Function<XMLTarget, XMLTarget> enrich = (tgt) -> enricher.enrich(header, tgt);
            Function<XMLTarget, XMLTarget> post = (tgt) -> poster.post(header, tgt);

            System.out.println("process header :" + header);

            return Optional.ofNullable(message)
                    .filter(preParseValidate)
                    .map(parse)
                    .filter(postParseValidate)
                    .map(convert)
                    .map(enrich)
                    .map(post)
                    .orElse(null);
        };*/
    }
}
