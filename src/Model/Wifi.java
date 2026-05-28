package Model;

public class Wifi extends Service {

    private int connectedDevices;
    private int streamingUse;
    private int gamingUse;
    private int connectionHours;

    public Wifi(double realWifi,
                int connectedDevices,
                int streamingUse,
                int gamingUse,
                int connectionHours) {

        setRealConsumption(realWifi);

        this.connectedDevices = connectedDevices;
        this.streamingUse = streamingUse;
        this.gamingUse = gamingUse;
        this.connectionHours = connectionHours;

    }

    public int getPoints() {

        return connectedDevices
                + streamingUse
                + gamingUse
                + connectionHours;

    }

}