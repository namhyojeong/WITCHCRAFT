package com.puppy.witchcraft.game.model.dto;

public class ImageDTO {
	
	private int imageNo;
	private String imageSave;
	private String imageName;
	private String imageType;
	
	public ImageDTO() {}

	public ImageDTO(int imageNo, String imageSave, String imageName, String imageType) {
		super();
		this.imageNo = imageNo;
		this.imageSave = imageSave;
		this.imageName = imageName;
		this.imageType = imageType;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getImageSave() {
		return imageSave;
	}

	public void setImageSave(String imageSave) {
		this.imageSave = imageSave;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "ImageDTO [imageNo=" + imageNo + ", imageSave=" + imageSave + ", imageName=" + imageName + ", imageType="
				+ imageType + "]";
	}
	
}
