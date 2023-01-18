package levels;

import entities.Crabby;
import main.Game;
import utilz.HelpMethods;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static utilz.HelpMethods.getLevelData;
import static utilz.HelpMethods.getCrabs;

public class Level {

	private BufferedImage img;
	private int[][] lvlData;
	private ArrayList<Crabby> crabs;

	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;

	public Level(BufferedImage img) {
		this.img = img;
		createLevelData();
		createEnemies();
		calcLvlOffsets();
	}

	private void calcLvlOffsets() {
		lvlTilesWide = img.getWidth();
		maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
		maxLvlOffsetX = Game.TILES_SIZE;
	}

	private void createEnemies() {
		crabs = HelpMethods.getCrabs(img);
	}

	private void createLevelData() {
		lvlData = getLevelData();
	}

	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	public int[][] getLevelData() {
		return lvlData;
	}

	public int getLvlOffset() {
		return maxLvlOffsetX;
	}

	public ArrayList<Crabby> getCrabs() {
		return crabs;
	}
}
