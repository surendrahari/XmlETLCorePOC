package edu.core.etl1.xml.action;

import edu.core.etl1.common.*;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.source.XMLSource;
import edu.core.etl1.xml.model.target.XMLTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class XMLProcessor implements Processor<String, String, XMLTarget> {

    @Autowired
    private Validator<String, String> preParserValidator;

    @Autowired
    private Parser<String, String, XMLSource> parser;

    @Autowired
    private Validator<String, XMLSource> postParserValidator;

    @Autowired
    private Convertor<String, XMLSource, XMLTarget> convertor;

    @Autowired
    private Enricher<String, XMLTarget> enricher;

    @Autowired
    private Poster<String, XMLTarget> poster;


    @Override
    public XMLTarget process(String header, String message) throws BaseException {
        System.out.println("process header :" + header);

        Predicate<String> preParseValidate = (msg) -> preParserValidator.validate(header, msg);
        Function<String, XMLSource> parse = (msg) -> parser.parse(header, msg);
        Predicate<XMLSource> postParseValidate = (src) -> postParserValidator.validate(header, src);
        Function<XMLSource, XMLTarget> convert = (src) -> convertor.convert(header, src);
        Function<XMLTarget, XMLTarget> enrich = (tgt) -> enricher.enrich(header, tgt);
        Function<XMLTarget, XMLTarget> post = (tgt) -> poster.post(header, tgt);

        return Optional.ofNullable(message)
                .filter(preParseValidate)
                .map(parse)
                .filter(postParseValidate)
                .map(convert)
                .map(enrich)
                .map(post)
                .orElse(null);
    }
}
