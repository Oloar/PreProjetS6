import javafx.event.EventHandler;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGame {
	
	private final Image img;
	private ImageView imgView;
	
	private Bloom bloom = new Bloom();
	
	private Integer clickX;
	private Integer clickY;

	ImageGame(){
		this.img = new Image("ressources/blank.png");
	}
	
	ImageGame (String ressource, double paneW, double paneH, int waffleW, int waffleH, Moteur m, Stage stage) {
		this.img = resample(new Image(ressource), 20);
		this.setImgView(new ImageView(this.img));
		this.getImgView().setFitWidth(((int)paneW/waffleW));
		this.getImgView().setFitHeight(((int)paneH/waffleH));
		this.getImgView().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clickX = GridPane.getColumnIndex(ImageGame.this.getImgView());
				clickY = GridPane.getRowIndex(ImageGame.this.getImgView());
				if (!m.isIA()) {
					m.eat(clickY, clickX); 
				}
				if (clickX == 0  &&  clickY == 0) {
					Joueur winner = m.endGame();
					WinInterface winInterface = new WinInterface();
					winInterface.initWinInterface(stage.getWidth(), stage.getHeight());
					stage.setScene(winInterface.getWinScene());
					winInterface.fetchWinner(winner);
					winInterface.start(stage);
				}
				System.out.println("Node: " + ImageGame.this.getImgView() + " at " + GridPane.getRowIndex(ImageGame.this.getImgView()) + "/" + GridPane.getColumnIndex(ImageGame.this.getImgView()));
			}
		});
		this.getImgView().addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bloom.setThreshold(0.5);
				ImageGame.this.getImgView().setEffect(bloom);
			}
		});
		this.getImgView().addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bloom.setThreshold(1.0);
				ImageGame.this.getImgView().setEffect(bloom);
			}
		});
	}
	
	
	
	public Integer getClickX () {
		return clickX;
	}
	
	
	
	public Integer getClickY () {
		return clickY;
	}

	
	
	public final ImageView getImgView() {
		return imgView;
	}

	
	
	public final void setImgView(ImageView imgView) {
		this.imgView = imgView;
	}
	
	
	
	private Image resample(Image input, int scaleFactor) {
		final int W = (int) input.getWidth();
		final int H = (int) input.getHeight();
		final int S = scaleFactor;

		WritableImage output = new WritableImage(
		  W * S,
		  H * S
		);

		PixelReader reader = input.getPixelReader();
		PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
		  for (int x = 0; x < W; x++) {
			final int argb = reader.getArgb(x, y);
			for (int dy = 0; dy < S; dy++) {
			  for (int dx = 0; dx < S; dx++) {
				writer.setArgb(x * S + dx, y * S + dy, argb);
			  }
			}
		  }
		}

		return output;
	}
	
}
