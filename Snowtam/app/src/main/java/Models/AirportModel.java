package Models;

public class AirportModel {

    private String name;
    private String countryName;
    private String cityName;
    private double latitude;
    private double longitude;
    private String ICAO_Code;
    private String snowtam;


    public AirportModel() {
    }

    public AirportModel(String name, String countryName, String cityName, double latitude, double longitude, String ICAO_Code, String snowtam) {
        this.name = name;
        this.countryName = countryName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ICAO_Code = ICAO_Code;
        this.snowtam = snowtam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getICAO_Code() {
        return ICAO_Code;
    }

    public void setICAO_Code(String ICAO_Code) {
        this.ICAO_Code = ICAO_Code;
    }

    public String getSnowtam() {
        return snowtam;
    }

    public void setSnowtam(String snowtam) {
        this.snowtam = snowtam;
    }

    @Override
    public String toString() {
        return "AirportModel{" +
                "name='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ICAO_Code='" + ICAO_Code + '\'' +
                ", snowtam='" + snowtam + '\'' +
                '}';
    }
}
