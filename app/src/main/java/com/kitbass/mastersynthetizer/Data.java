package com.kitbass.mastersynthetizer;

public class Data {
    public int imageId;
    public int soundId;

    Data(int imageId, int soundId) {
        this.imageId = imageId;
        this.soundId = soundId;
    }

    public int getImageId() {
        return imageId;
    }

    public int getSoundId() {
        return soundId;
    }
}
