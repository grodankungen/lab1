package src;

public enum CarType {
    VOLVO240("pics/Volvo240.jpg"),
    SAAB95("pics/Saab95.jpg"),
    SCANIA("pics/Scania.jpg");

    CarType(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    private final String imgPath;
}
