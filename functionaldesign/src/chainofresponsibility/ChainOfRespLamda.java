package chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChainOfRespLamda {

    public static Optional<String> pareseText(File file) {
        if (file.getType() == File.Type.TEXT)
            return Optional.of("Text File:" + file.getContent());
        else
            return Optional.empty();
    }

    public static Optional<String> paresePresentation(File file) {
        if (file.getType() == File.Type.PRESENTATION)
            return Optional.of("Text File:" + file.getContent());
        else
            return Optional.empty();
    }

    public static Optional<String> pareseAudio(File file) {
        if (file.getType() == File.Type.AUDIO)
            return Optional.of("Text File:" + file.getContent());
        else
            return Optional.empty();
    }

    public static Optional<String> pareseVideo(File file) {
        if (file.getType() == File.Type.VIDEO)
            return Optional.of("Text File:" + file.getContent());
        else
            return Optional.empty();
    }

    public static void main(String[] args) {

        File audioFile = new File(File.Type.AUDIO, "This is Audio file");
        File videoFile = new File(File.Type.VIDEO, "This is Video file");

        System.out.println(
                Stream.<Function<File, Optional<String>>>of(
                        ChainOfRespLamda::pareseText
                        , ChainOfRespLamda::paresePresentation
                        , ChainOfRespLamda::pareseAudio
                        , ChainOfRespLamda::pareseVideo
                )
                        .map(f -> f.apply(videoFile))
                        .filter(Optional::isPresent)
                        .findFirst()
                        .flatMap(Function.identity())
                        .orElseThrow(RuntimeException::new));

    }
}
