package com.vertical.cloudblob.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Images.
 */
@Document(collection = "images")
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    
    @Field("thumbnail")
    private byte[] thumbnail;

    @Field("thumbnail_content_type")
    private String thumbnailContentType;

    
    @Field("original")
    private byte[] original;

    @Field("original_content_type")
    private String originalContentType;

    @Field("banner_tall")
    private byte[] bannerTall;

    @Field("banner_tall_content_type")
    private String bannerTallContentType;

    @Field("banner_wide")
    private byte[] bannerWide;

    @Field("banner_wide_content_type")
    private String bannerWideContentType;

    @Field("circle")
    private byte[] circle;

    @Field("circle_content_type")
    private String circleContentType;

    @Field("sharpened")
    private byte[] sharpened;

    @Field("sharpened_content_type")
    private String sharpenedContentType;

    @Field("square")
    private byte[] square;

    @Field("square_content_type")
    private String squareContentType;

    @Field("watermark")
    private byte[] watermark;

    @Field("watermark_content_type")
    private String watermarkContentType;

    @Field("ref_id")
    private Long refId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public Images thumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailContentType() {
        return thumbnailContentType;
    }

    public Images thumbnailContentType(String thumbnailContentType) {
        this.thumbnailContentType = thumbnailContentType;
        return this;
    }

    public void setThumbnailContentType(String thumbnailContentType) {
        this.thumbnailContentType = thumbnailContentType;
    }

    public byte[] getOriginal() {
        return original;
    }

    public Images original(byte[] original) {
        this.original = original;
        return this;
    }

    public void setOriginal(byte[] original) {
        this.original = original;
    }

    public String getOriginalContentType() {
        return originalContentType;
    }

    public Images originalContentType(String originalContentType) {
        this.originalContentType = originalContentType;
        return this;
    }

    public void setOriginalContentType(String originalContentType) {
        this.originalContentType = originalContentType;
    }

    public byte[] getBannerTall() {
        return bannerTall;
    }

    public Images bannerTall(byte[] bannerTall) {
        this.bannerTall = bannerTall;
        return this;
    }

    public void setBannerTall(byte[] bannerTall) {
        this.bannerTall = bannerTall;
    }

    public String getBannerTallContentType() {
        return bannerTallContentType;
    }

    public Images bannerTallContentType(String bannerTallContentType) {
        this.bannerTallContentType = bannerTallContentType;
        return this;
    }

    public void setBannerTallContentType(String bannerTallContentType) {
        this.bannerTallContentType = bannerTallContentType;
    }

    public byte[] getBannerWide() {
        return bannerWide;
    }

    public Images bannerWide(byte[] bannerWide) {
        this.bannerWide = bannerWide;
        return this;
    }

    public void setBannerWide(byte[] bannerWide) {
        this.bannerWide = bannerWide;
    }

    public String getBannerWideContentType() {
        return bannerWideContentType;
    }

    public Images bannerWideContentType(String bannerWideContentType) {
        this.bannerWideContentType = bannerWideContentType;
        return this;
    }

    public void setBannerWideContentType(String bannerWideContentType) {
        this.bannerWideContentType = bannerWideContentType;
    }

    public byte[] getCircle() {
        return circle;
    }

    public Images circle(byte[] circle) {
        this.circle = circle;
        return this;
    }

    public void setCircle(byte[] circle) {
        this.circle = circle;
    }

    public String getCircleContentType() {
        return circleContentType;
    }

    public Images circleContentType(String circleContentType) {
        this.circleContentType = circleContentType;
        return this;
    }

    public void setCircleContentType(String circleContentType) {
        this.circleContentType = circleContentType;
    }

    public byte[] getSharpened() {
        return sharpened;
    }

    public Images sharpened(byte[] sharpened) {
        this.sharpened = sharpened;
        return this;
    }

    public void setSharpened(byte[] sharpened) {
        this.sharpened = sharpened;
    }

    public String getSharpenedContentType() {
        return sharpenedContentType;
    }

    public Images sharpenedContentType(String sharpenedContentType) {
        this.sharpenedContentType = sharpenedContentType;
        return this;
    }

    public void setSharpenedContentType(String sharpenedContentType) {
        this.sharpenedContentType = sharpenedContentType;
    }

    public byte[] getSquare() {
        return square;
    }

    public Images square(byte[] square) {
        this.square = square;
        return this;
    }

    public void setSquare(byte[] square) {
        this.square = square;
    }

    public String getSquareContentType() {
        return squareContentType;
    }

    public Images squareContentType(String squareContentType) {
        this.squareContentType = squareContentType;
        return this;
    }

    public void setSquareContentType(String squareContentType) {
        this.squareContentType = squareContentType;
    }

    public byte[] getWatermark() {
        return watermark;
    }

    public Images watermark(byte[] watermark) {
        this.watermark = watermark;
        return this;
    }

    public void setWatermark(byte[] watermark) {
        this.watermark = watermark;
    }

    public String getWatermarkContentType() {
        return watermarkContentType;
    }

    public Images watermarkContentType(String watermarkContentType) {
        this.watermarkContentType = watermarkContentType;
        return this;
    }

    public void setWatermarkContentType(String watermarkContentType) {
        this.watermarkContentType = watermarkContentType;
    }

    public Long getRefId() {
        return refId;
    }

    public Images refId(Long refId) {
        this.refId = refId;
        return this;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Images)) {
            return false;
        }
        return id != null && id.equals(((Images) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Images{" +
            "id=" + getId() +
            ", thumbnail='" + getThumbnail() + "'" +
            ", thumbnailContentType='" + getThumbnailContentType() + "'" +
            ", original='" + getOriginal() + "'" +
            ", originalContentType='" + getOriginalContentType() + "'" +
            ", bannerTall='" + getBannerTall() + "'" +
            ", bannerTallContentType='" + getBannerTallContentType() + "'" +
            ", bannerWide='" + getBannerWide() + "'" +
            ", bannerWideContentType='" + getBannerWideContentType() + "'" +
            ", circle='" + getCircle() + "'" +
            ", circleContentType='" + getCircleContentType() + "'" +
            ", sharpened='" + getSharpened() + "'" +
            ", sharpenedContentType='" + getSharpenedContentType() + "'" +
            ", square='" + getSquare() + "'" +
            ", squareContentType='" + getSquareContentType() + "'" +
            ", watermark='" + getWatermark() + "'" +
            ", watermarkContentType='" + getWatermarkContentType() + "'" +
            ", refId=" + getRefId() +
            "}";
    }
}
