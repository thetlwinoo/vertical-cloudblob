package com.vertical.cloudblob.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.vertical.cloudblob.domain.Images} entity.
 */
public class ImagesDTO implements Serializable {
    
    private String id;

    
    private byte[] thumbnail;

    private String thumbnailContentType;
    
    private byte[] original;

    private String originalContentType;
    private byte[] bannerTall;

    private String bannerTallContentType;
    private byte[] bannerWide;

    private String bannerWideContentType;
    private byte[] circle;

    private String circleContentType;
    private byte[] sharpened;

    private String sharpenedContentType;
    private byte[] square;

    private String squareContentType;
    private byte[] watermark;

    private String watermarkContentType;
    private Long refId;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailContentType() {
        return thumbnailContentType;
    }

    public void setThumbnailContentType(String thumbnailContentType) {
        this.thumbnailContentType = thumbnailContentType;
    }

    public byte[] getOriginal() {
        return original;
    }

    public void setOriginal(byte[] original) {
        this.original = original;
    }

    public String getOriginalContentType() {
        return originalContentType;
    }

    public void setOriginalContentType(String originalContentType) {
        this.originalContentType = originalContentType;
    }

    public byte[] getBannerTall() {
        return bannerTall;
    }

    public void setBannerTall(byte[] bannerTall) {
        this.bannerTall = bannerTall;
    }

    public String getBannerTallContentType() {
        return bannerTallContentType;
    }

    public void setBannerTallContentType(String bannerTallContentType) {
        this.bannerTallContentType = bannerTallContentType;
    }

    public byte[] getBannerWide() {
        return bannerWide;
    }

    public void setBannerWide(byte[] bannerWide) {
        this.bannerWide = bannerWide;
    }

    public String getBannerWideContentType() {
        return bannerWideContentType;
    }

    public void setBannerWideContentType(String bannerWideContentType) {
        this.bannerWideContentType = bannerWideContentType;
    }

    public byte[] getCircle() {
        return circle;
    }

    public void setCircle(byte[] circle) {
        this.circle = circle;
    }

    public String getCircleContentType() {
        return circleContentType;
    }

    public void setCircleContentType(String circleContentType) {
        this.circleContentType = circleContentType;
    }

    public byte[] getSharpened() {
        return sharpened;
    }

    public void setSharpened(byte[] sharpened) {
        this.sharpened = sharpened;
    }

    public String getSharpenedContentType() {
        return sharpenedContentType;
    }

    public void setSharpenedContentType(String sharpenedContentType) {
        this.sharpenedContentType = sharpenedContentType;
    }

    public byte[] getSquare() {
        return square;
    }

    public void setSquare(byte[] square) {
        this.square = square;
    }

    public String getSquareContentType() {
        return squareContentType;
    }

    public void setSquareContentType(String squareContentType) {
        this.squareContentType = squareContentType;
    }

    public byte[] getWatermark() {
        return watermark;
    }

    public void setWatermark(byte[] watermark) {
        this.watermark = watermark;
    }

    public String getWatermarkContentType() {
        return watermarkContentType;
    }

    public void setWatermarkContentType(String watermarkContentType) {
        this.watermarkContentType = watermarkContentType;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImagesDTO)) {
            return false;
        }

        return id != null && id.equals(((ImagesDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImagesDTO{" +
            "id=" + getId() +
            ", thumbnail='" + getThumbnail() + "'" +
            ", original='" + getOriginal() + "'" +
            ", bannerTall='" + getBannerTall() + "'" +
            ", bannerWide='" + getBannerWide() + "'" +
            ", circle='" + getCircle() + "'" +
            ", sharpened='" + getSharpened() + "'" +
            ", square='" + getSquare() + "'" +
            ", watermark='" + getWatermark() + "'" +
            ", refId=" + getRefId() +
            "}";
    }
}
