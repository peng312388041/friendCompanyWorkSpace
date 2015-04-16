package com.e6mall.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {

	/**
	 * 按源图比例缩放，生成高质量缩略图
	 * 
	 * @param imageFile
	 *            源图文件
	 * @param thumbnailFile
	 *            要保存到的缩略图文件
	 * @param maxWidth
	 *            缩略图的最大宽度
	 * @param maxHeight
	 *            缩略图的最大高度
	 * @throws IOException
	 *             读取源图imageFile出错，或者用户指定的thumbnailFile无法被创建时
	 */
	public static void createThumbnail(File imageFile, File thumbnailFile,
			int maxWidth, int maxHeight) throws IOException {
		if (imageFile == null) {
			throw new IllegalArgumentException("imageFile connot be null!");
		}
		if (thumbnailFile == null) {
			throw new IllegalArgumentException("thumbnailFile connot be null!");
		}
		if (maxWidth <= 0) {
			throw new IllegalArgumentException("maxWidth must > 0");
		}
		if (maxHeight <= 0) {
			throw new IllegalArgumentException("maxHeight must > 0");
		}

		try {
			BufferedImage image = ImageIO.read(imageFile);

			/* 源图宽和高 */
			int imageWidth = image.getWidth();
			int imageHeight = image.getHeight();
			if (maxWidth >= imageWidth && maxHeight >= imageHeight)
				return;

			/* 按比例缩放图像 */
			double scaleZ = (double) imageWidth / imageHeight;
			if (scaleZ > 0) {
				imageWidth = maxWidth;
				imageHeight = (int) (maxWidth / scaleZ);
			} else {
				imageWidth = (int) (maxHeight * scaleZ);
				imageHeight = maxHeight;
			}

			/* 根据源图和缩略图宽高生成一张图片？ */
			ImageFilter filter = new java.awt.image.AreaAveragingScaleFilter(
					imageWidth, imageHeight);
			ImageProducer producer = new FilteredImageSource(image.getSource(),
					filter);
			Image newImage = Toolkit.getDefaultToolkit().createImage(producer);
			ImageIcon imageIcon = new ImageIcon(newImage);
			Image scaleImage = imageIcon.getImage();

			BufferedImage thumbnail = new BufferedImage(imageWidth,
					imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = thumbnail.createGraphics();
			g2d.drawImage(scaleImage, 0, 0, null);
			g2d.dispose();

			ImageIO.write(thumbnail, "jpeg", thumbnailFile);

		} catch (IOException e) {
			throw new IOException(
					"Connot create thumbnail, Please check 'imageFile' or 'thumbnailFile'!");
		}
	}

	/**
	 * 给图片添加水印，并可调节水印图片的透明度
	 * 
	 * @param tragetFile
	 *            目标图片文件
	 * @param watermarkFile
	 *            水印图片
	 * @param x
	 *            水印在目标图片的横坐标
	 * @param y
	 *            水印在目标图片的纵坐标
	 * @param alpha
	 *            透明度，必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字，值越小水印透明度越高
	 * @throws IOException
	 *             读取目标图片或水印图片出错时
	 */
	public static void makeWatermark(File tragetFile, File watermarkFile,
			int x, int y, float alpha) throws IOException {
		if (tragetFile == null) {
			throw new IllegalArgumentException("imageFile connot be null!");
		}
		if (watermarkFile == null) {
			throw new IllegalArgumentException("thumbnailFile connot be null!");
		}
		if (alpha < 0 || alpha > 1) {
			throw new IllegalArgumentException(
					"alpha must be between 0.0 and 1.1!");
		}
		try {
			Image target = ImageIO.read(tragetFile);
			int targetWidth = target.getWidth(null);
			int targetHeight = target.getHeight(null);

			Image watermark = ImageIO.read(watermarkFile);
			int waterWidth = watermark.getWidth(null);
			int waterHeight = watermark.getHeight(null);

			BufferedImage bufferedImage = new BufferedImage(targetWidth,
					targetHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();

			/* 从(0,0)坐标开始，把目标图像画进去 */
			g2d.drawImage(target, 0, 0, targetWidth, targetHeight, null);
			/* 透明度设置 */
			g2d.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_ATOP, alpha));
			/* 根据制定坐标(x,y)，把水印图像画进去 */
			g2d.drawImage(watermark, x, y, waterWidth, waterHeight, null);
			g2d.dispose();

			ImageIO.write(bufferedImage, "jpeg", tragetFile);
		} catch (IOException e) {
			throw new IOException(
					"Connot read image, Please check 'targetFile' or 'watermarkFile'!");
		}
	}

	public static void main(String[] args) {
		try {
			// int width = 90;
			// int height = 90;
			// createThumbnail("C:\\测试用图片\\1.bmp", "C:\\1.bmp", width, height);
			// createThumbnail("C:\\测试用图片\\九寨沟.jpg", "C:\\九寨沟.jpg", width,
			// height);
			// createThumbnail("C:\\测试用图片\\u.gif", "C:\\u.gif", width, height);
			File file1 = new File("F:\\1274329919883.gif");
			//File file2 = new File("F:\\gaojiaohui.jpg");
			//makeWatermark(file1, file2, 10,10, 0.2f);
			createThumbnail(file1, new File("F:\\2.gif"), 50, 50);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}