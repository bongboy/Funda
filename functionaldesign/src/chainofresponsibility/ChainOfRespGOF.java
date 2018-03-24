package chainofresponsibility;

public class ChainOfRespGOF {

    public static void main(String[] args) {

        FileParser textFileParser = new TextFileParser();
        FileParser presentationFileParser = new PresentationFileParser();
        FileParser audioFileParser = new AudioFileParser();

        textFileParser.setNextParser(presentationFileParser).setNextParser(audioFileParser);
        //presentationFileParser.setNextParser(audioFileParser);

        File audioFile = new File(File.Type.AUDIO, "This is Audio file");
        File videoFile = new File(File.Type.VIDEO, "This is Video file");

        System.out.println(textFileParser.parse(videoFile));
    }

    public interface FileParser {
        String parse(File file);

        FileParser setNextParser(FileParser next);
    }

    public static abstract class AbstractFileParser implements FileParser {
        protected FileParser next;

        @Override
        public FileParser setNextParser(FileParser next) {
            this.next = next;
            return next;
        }
    }

    public static class TextFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == File.Type.TEXT)
                return "Text File:" + file.getContent();
            else if (next != null)
                return next.parse(file);
            else
                throw new RuntimeException("Unknown file: " + file);
        }
    }

    public static class PresentationFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == File.Type.PRESENTATION)
                return "Presentation File:" + file.getContent();
            else if (next != null)
                return next.parse(file);
            else
                throw new RuntimeException("Unknown file: " + file);
        }
    }

    public static class AudioFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == File.Type.AUDIO)
                return "Audio File:" + file.getContent();
            else if (next != null)
                return next.parse(file);
            else
                throw new RuntimeException("Unknown file: " + file);
        }
    }

    public static class VideoFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == File.Type.VIDEO)
                return "Video File:" + file.getContent();
            else if (next != null)
                return next.parse(file);
            else
                throw new RuntimeException("Unknown file: " + file);
        }
    }
}
