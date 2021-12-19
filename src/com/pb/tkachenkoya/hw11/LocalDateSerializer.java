package com.pb.tkachenkoya.hw11;


import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class  LocalDateSerializer  extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    public  LocalDateSerializer () {
        super(LocalDate.class);
    }


    @Override
    public void serialize(LocalDate localDate, com.fasterxml.jackson.core.JsonGenerator jsonGenerator,
                          com.fasterxml.jackson.databind.SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
