package edu.core.etl2.xml.config;

import edu.core.etl2.common.*;
import edu.core.etl2.common.field.FieldConvertor;
import edu.core.etl2.common.field.FieldEnricher;
import edu.core.etl2.common.field.FieldValidator;
import edu.core.etl2.common.model.Data;
import edu.core.etl2.xml.model.fields.XMLFieldNames;
import edu.core.etl2.xml.model.fields.XMLID;
import edu.core.etl2.xml.model.fields.XMLName;
import edu.core.etl2.xml.model.fields.XMLNetAmount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
public class XMLConfig {

    @Bean
    public Validator<String, String> preParserValidator() {
        System.out.println("preParseValidator init.......");
        return (header, message) -> {
            // Validate logic here or separate class which implements Validator interface

            Predicate<String> headerValidation = (headerObject) -> Optional.ofNullable(headerObject)
                    .map(String::trim)
                    .filter(filterHeader -> !filterHeader.isEmpty())
                    .isPresent();

            Predicate<String> messageValidation = (messageObject) -> Optional.ofNullable(messageObject)
                    .map(String::trim)
                    .filter(filterHeader -> !filterHeader.isEmpty())
                    .isPresent();

            boolean isValid = headerValidation.test(header) && messageValidation.test(message);

            System.out.println("preParseValidator  : isValid=" + isValid + ", header=" + header + ", message=" + message);

            return isValid;
        };
    }

    @Bean
    public Parser<String, String, Data> parser() {
        System.out.println("parser init.......");

        return (header, message) -> {
            // TODO Parse logic here or separate class which implements Parser interface
            int count = 0;
            Data data = new Data();
            for (String splitData : message.split(",")) {
                if (count == 0) {
                    data.addField(XMLFieldNames.ID, new XMLID(splitData));
                } else if (count == 1) {
                    data.addField(XMLFieldNames.NAME, new XMLName(splitData));
                } else if (count == 2) {
                    data.addField(XMLFieldNames.NET_AMOUNT, new XMLNetAmount(splitData));
                }
                count++;
            }

            // parsed field values will have to map with Bean object (this is transform logic)
//            data = new Data()
//                    .addField(FIXMLFieldNames.ID, new FldId("1a"))
//                    .addField(FIXMLFieldNames.NAME, new FldName(message))
//                    .addField(FIXMLFieldNames.NET_AMOUNT, new FldNetAmount("10.0"));

            System.out.println("parser  : header=" + header + ", message=" + message + ", Data=" + data);

            return data;
        };
    }

    @Bean
    public Validator<String, Data> postParserValidator() {
        System.out.println("postParseValidator init.......");

        return (header, data) -> {
            // Validate logic here or separate class which implements Validator interface
            boolean isFieldsValid = data.getFieldNames()
                    .stream()
                    .map(name -> data.getField(name))
                    .peek(field -> System.out.println("Valid : " + field))
                    .allMatch(FieldValidator::isValid);

            System.out.println("postParseValidator  : isFieldsValid=" + isFieldsValid + ", header=" + header + ", Data=" + data);

            return isFieldsValid;
        };
    }

    @Bean
    public Convertor<String, Data> convertor() {
        System.out.println("convertor init.......");

        return (header, data) -> {
            // Convertor logic here or separate class which implements Convertor interface
            boolean isFieldsConverted = data.getFieldNames()
                    .stream()
                    .map(name -> data.getField(name))
                    .peek(field -> System.out.println("Convert : " + field))
                    .allMatch(FieldConvertor::convert);

            System.out.println("convertor  : isFieldsConverted=" + isFieldsConverted + ", header=" + header + ", Data=" + data);

            return data;
        };
    }

    @Bean
    public Enricher<String, Data> enricher() {
        System.out.println("enricher init.......");

        return (header, data) -> {
            // enrich logic here or separate class which implements Enricher interface
            boolean isFieldsEnriched = data.getFieldNames()
                    .stream()
                    .map(name -> data.getField(name))
                    .peek(field -> System.out.println("Enrich : " + field))
                    .allMatch(FieldEnricher::enrich);

            System.out.println("enricher  : isFieldsEnriched=" + isFieldsEnriched + ", header=" + header + ", Data=" + data);

            return data;
        };
    }

    @Bean
    public Poster<String, Data> poster() {
        System.out.println("poster init.......");

        return (header, data) -> {
            // TODO Poster logic here or separate class which implements Poster interface
            System.out.println("poster : " + header + " " + data);
            return data;
        };
    }

    @Bean
    public Processor<String, String, Data> processor() {
        System.out.println("processor init.......");

        final Validator<String, String> preParserValidator = preParserValidator();
        final Parser<String, String, Data> parser = parser();
        final Validator<String, Data> postParserValidator = postParserValidator();
        final Convertor<String, Data> convertor = convertor();
        final Enricher<String, Data> enricher = enricher();
        final Poster<String, Data> poster = poster();

        return (header, message) -> {
            Predicate<String> preParseValidate = (msg) -> preParserValidator.validate(header, msg);
            Function<String, Data> parse = (msg) -> parser.parse(header, msg);
            Predicate<Data> postParseValidate = (src) -> postParserValidator.validate(header, src);
            Function<Data, Data> convert = (src) -> convertor.convert(header, src);
            Function<Data, Data> enrich = (tgt) -> enricher.enrich(header, tgt);
            Function<Data, Data> post = (tgt) -> poster.post(header, tgt);

            System.out.println("process begin :" + header);

            Data data = Optional.ofNullable(message)
                    .filter(preParseValidate)
                    .map(parse)
                    .filter(postParseValidate)
                    .map(convert)
                    .map(enrich)
                    .map(post)
                    .orElse(null);

            System.out.println("process end :" + header + " " + data);

            return data;
        };
    }
}
