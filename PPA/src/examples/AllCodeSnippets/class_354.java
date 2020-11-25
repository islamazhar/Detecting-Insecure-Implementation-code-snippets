package examples.AllCodeSnippets; 
public class class_354 extends Activity {

    public List<PeerConnection.IceServer> iceServers;
    private GLSurfaceView videoView;
    public static SocketIO socket;
    ArrayList<String> userIDs = new ArrayList<>();
    private static final String FIELD_TRIAL_VP9 = "WebRTC-SupportVP9/Enabled/";
    String RoomId = ";
    String sreverURL = "http://xx.xx.xx.xx:xxxx/";
    private EditText roomid;
    private VideoRenderer.Callbacks remote_view;
    private VideoRenderer.Callbacks local_view;
    protected PeerConnectionFactory factory;
    PeerConnectionFactory.Options options = null;
    Events pc_events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        videoView = (GLSurfaceView) findViewById(R.id.glview_call_remote);
        VideoRendererGui.setView(videoView, new Runnable() {
            @Override
            public void run() {
                createPeerConnectionFactory();
            }
        });

        remote_view = VideoRendererGui.create(0, 0, 100, 100, ScalingType.SCALE_ASPECT_FIT, false);
        local_view = VideoRendererGui.create(0, 0, 100, 100, ScalingType.SCALE_ASPECT_FILL, true);
        iceServers = new ArrayList<>();
        IceServer icc = new IceServer("stun:stun.l.google.com:19302", ", ");
        iceServers.add(icc);
        roomid = (EditText) findViewById(R.id.roomId);
        Random rand = new Random();
        roomid.setText(" + rand.nextInt(9999));
        pc_events = new peerEventHandler();
    }

    private void createPeerConnectionFactory() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                PeerConnectionFactory.initializeFieldTrials(FIELD_TRIAL_VP9);
                PeerConnectionFactory.initializeAndroidGlobals(Home.this, true, true, true, VideoRendererGui.getEGLContext());
                try {
                    factory = new PeerConnectionFactory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void ondail(View view) {

        try {

            try {
                SocketIO.setDefaultSSLSocketFactory(SSLContext.getDefault());
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }

            socket = new SocketIO();

            socket.connect(sreverURL, new IOCallback() {

                @Override
                public void onMessage(JSONObject json, IOAcknowledge ack) {
                }
                @Override
                public void onMessage(String data, IOAcknowledge ack) {
                }
                @Override
                public void onError(SocketIOException socketIOException) {
                    socketIOException.printStackTrace();
                }
                @Override
                public void onDisconnect() {
                }
                @Override
                public void onConnect() {
                    showToast("Connected to " + sreverURL);
                }
                @Override
                public void on(final String event, IOAcknowledge ack, final Object... args) {

                    Log.e("Socked.on", event + ", " + args);
                    switch (getEvent(event)) {

                        case LOG :
                            break;
                        case MESSAGE :
                            if (args instanceof Object[]) {
                                pc_events.setMessage(args[0].toString());
                            } else {
                                pc_events.setMessage(args.toString());
                            }
                            break;
                        case CREATED :
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    showToast("Room Created " + args[0]);
                                }
                            });
                            break;
                        case BROADCAST :
                            break;
                        case JOIN :
                            break;
                        case EMIT :
                            Log.e("Socked.onEMIT", args.toString());
                            startCall();
                            pc_events.createOffer();
                            break;

                        case ERROR :
                            Log.e("Socked.onERROR", args.toString());
                            break;

                        default :

                            break;
                    }
                }
            });

            try {
                RoomId = roomid.getText().toString();
            } catch (Exception e) {
            }

            socket.emit("create or join", RoomId);

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

    }

    public void oncancel(View view) {

    }

    public SocketEvent getEvent(String eventString) {

        SocketEvent eventType;

        try {

            if (eventString.contains("log")) {
                eventType = SocketEvent.LOG;
            } else if (eventString.contains("created")) {
                eventType = SocketEvent.CREATED;
            } else if (eventString.contains("emit():")) {
                eventType = SocketEvent.EMIT;
            }

            else if (eventString.contains("broadcast():")) {
                eventType = SocketEvent.BROADCAST;
            } else if (eventString.contains("message")) {
                eventType = SocketEvent.MESSAGE;
            } else if (eventString.toLowerCase().substring(0, 20).contains("join")) {
                eventType = SocketEvent.JOIN;
            } else {
                eventType = SocketEvent.ERROR;
            }

        } catch (Exception e) {
            eventType = SocketEvent.ERROR;
        }

        return eventType;

    }

    public static interface Events {

        public void peerConnectionEvent(VideoRenderer.Callbacks localRender, VideoRenderer.Callbacks remoteRender);

        public void setFactory(PeerConnectionFactory factory);

        public void setMessage(String message);
        public void createOffer();

        public void sendMessage(String msg);
    }

    private void startCall() {

        pc_events.setFactory(factory);

        pc_events.peerConnectionEvent(remote_view, local_view);

    }

    public void showToast(final String message) {

        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(Home.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void makeOffer(View v) {
        pc_events.sendMessage("Hello");
    }

}
