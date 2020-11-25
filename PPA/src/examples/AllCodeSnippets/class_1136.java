package examples.AllCodeSnippets; 
public class class_1136 extends NanoHTTPD
{
    private Context ctx;
    private MediaPlayer mediaPlayer;
    public PlayMusicServer(Context c) throws IOException
    {
        super(8080, new File("."));
        ctx = c;
    }

    public Response serve( String uri, String method, Properties header, Properties parms, Properties files )
    {
        Log.i(FileLog.myTag, method + " '" + uri + "' " );
        String msg = ";

        if ( parms.getProperty("play") != null){ 
            String PATH_TO_FILE = parms.getProperty("play")
            mediaPlayer = new  MediaPlayer();
            mediaPlayer.setDataSource(PATH_TO_FILE);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }

        return new NanoHTTPD.Response( HTTP_OK, MIME_HTML, msg );
    }

}
