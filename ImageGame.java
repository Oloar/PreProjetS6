import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageGame {
	
	private Image img;
	private ImageView imgView;
	
	ImageGame (String ressource, double paneW, double paneH, int waffleW, int waffleH) {
		this.img = new Image(ressource);
		this.setImgView(new ImageView(this.img));
		this.getImgView().setFitWidth(((int)paneW/waffleW));
		this.getImgView().setFitHeight(((int)paneH/waffleH));
	}

	public ImageView getImgView() {
		return imgView;
	}

	public void setImgView(ImageView imgView) {
		this.imgView = imgView;
	}
	
}
