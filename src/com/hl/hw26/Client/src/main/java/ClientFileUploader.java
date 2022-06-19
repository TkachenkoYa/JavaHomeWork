import java.io.*;
import java.net.Socket;

public class ClientFileUploader {
    private Socket clientSocket;
    private PrintWriter outMessage;

    public void uploadFile(String inMes) {
        String[] str = inMes.split(" ");
        File file = new File(str[2]);
        if (file.isFile()) {
            try (DataOutputStream outD = new DataOutputStream(clientSocket.getOutputStream())) {

                outD.writeInt(1);
                outD.writeUTF(file.getAbsolutePath());
                outD.writeUTF(file.getName());
                outD.writeLong(file.length());

                FileInputStream in = new FileInputStream(file);
                byte[] buffer = new byte[64 * 1024];
                int count;
                while ((count = in.read(buffer)) != -1) {
                    outD.write(buffer, 0, count);
                }
                outMessage.println("File's uploading is complete");
                outD.flush();
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
