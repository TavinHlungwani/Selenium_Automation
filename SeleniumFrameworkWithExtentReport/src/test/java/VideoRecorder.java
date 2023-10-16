/*
 * import java.awt.AWTException; import java.io.File; import
 * java.io.IOException;
 * 
 * import javax.imageio.ImageIO;
 * 
 * import net.sf.monte.media.Format; import net.sf.monte.media.VideoFormatKeys;
 * import net.sf.monte.media.avi.AVIWriter;
 * 
 * public class VideoRecorder {
 * 
 * private AVIWriter writer;
 * 
 * public void startRecording(String outputPath) { Format outputFormat = new
 * Format(MediaTypeKeys.VIDEO, VideoFormatKeys.COMPRESSOR_NAME,
 * VideoFormatKeys.QUICKTIME_ANIMATION); File file = new File(outputPath); try {
 * writer = new AVIWriter(file); writer.addVideoTrack(outputFormat); } catch
 * (IOException e) { e.printStackTrace(); } }
 * 
 * public void recordScreen() { try { BufferedImage screenshot = new
 * Robot().createScreenCapture(new
 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); writer.write(0,
 * screenshot, 1); } catch (AWTException | IOException e) { e.printStackTrace();
 * } }
 * 
 * public void stopRecording() { if (writer != null) { try { writer.close(); }
 * catch (IOException e) { e.printStackTrace(); } } } }
 */