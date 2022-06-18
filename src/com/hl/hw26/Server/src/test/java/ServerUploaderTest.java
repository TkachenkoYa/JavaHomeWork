package com.hl.hw26.Server.src.test.java;

import com.hl.hw26.Server.src.main.java.ServerUploader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServerUploaderTest {
    ServerUploader serverUploader = new ServerUploader();

    @Test
    public void shouldTrueIfFileUpload(){
        assertThat (serverUploader).isNotNull();
    }
}
