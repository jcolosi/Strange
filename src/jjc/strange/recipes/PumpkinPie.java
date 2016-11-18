package jjc.strange.recipes;

/**
 * This is a recipe for Pumpkin Pie. I find it more readable than most recipes.
 * It's an experiment in self-documenting code. It contains no comments.
 * <p>
 * Also, it's delicious.
 * 
 * @author John Colosi
 */
public class PumpkinPie {

	Ingredient pumpkin = new Ingredient("Pumpkin", 15, "oz");
	Ingredient brownSugar = new Ingredient("Brown Sugar", 1, "cup");
	Ingredient butter = new Ingredient("Butter", .25f, "stick");
	Ingredient cinnamon = new Ingredient("Cinnamon", 1, "tsp");
	Ingredient ginger = new Ingredient("Ginger", 1, "tsp");
	Ingredient nutmeg = new Ingredient("Nutmeg", 1, "tsp");
	Ingredient salt = new Ingredient("Salt", 1, "tsp");
	Ingredient evaporatedMilk = new Ingredient("Evaporated Milk", 12, "oz");
	Ingredient eggWhites = new Ingredient("Egg Whites", 3, "egg");
	Ingredient sugar = new Ingredient("Sugar", .5f, "cup");
	Ingredient pieCrust = new Ingredient("Pie Crust", 1, "crust");

	static public void main(String[] args) {
		PumpkinPie pie = new PumpkinPie();
	}

	public PumpkinPie() {
		Ingredient filling = makeFilling();
		Ingredient merange = makeMerange();
		Container piePan = assemble(filling, merange);
		bake(piePan);
	}

	public Ingredient makeFilling() {
		Container mixingBowl = new Container("Filling");
		mixingBowl.add(pumpkin, brownSugar, butter, cinnamon, ginger, nutmeg, salt);
		mixingBowl.beatUntil(Texture.FLUFFY);
		mixingBowl.add(evaporatedMilk);
		mixingBowl.beatUntil(Texture.BLENDED);
		return mixingBowl.getContents();
	}

	public Ingredient makeMerange() {
		Container mixingBowl = new Container("Merange");
		mixingBowl.add(eggWhites);
		mixingBowl.beatUntil(Texture.FLUFFY);
		mixingBowl.addSlowly(sugar);
		mixingBowl.beatUntil(Texture.STIFF_PEAKS);
		return mixingBowl.getContents();
	}

	public Container assemble(Ingredient filling, Ingredient merange) {
		Container mixingBowl = new Container("Merange");
		mixingBowl.foldSlowly(filling, merange);
		Container piePan = new Container("Pie");
		piePan.pourInto(mixingBowl.getContents());
		return piePan;
	}

	public void bake(Container piePan) {
		piePan.bakeAtDegreesForMinutes(400, 10);
		piePan.bakeAtDegreesForMinutesUntilTexture(350, 45, Texture.SET);
	}
}

class Ingredient {
	String name;
	float count;
	String unit;

	public Ingredient(String name, float count, String unit) {
		this.name = name;
		this.count = count;
		this.unit = unit;
	}
}

class Container {
	String product;

	public Container(String product) {
		this.product = product;
	}

	public void add(Ingredient... ingredients) {}

	public void addSlowly(Ingredient... ingredients) {}

	public void foldSlowly(Ingredient... ingredients) {}

	public void pourInto(Ingredient... ingredients) {}

	public void beatUntil(Texture texture) {}

	public void bakeAtDegreesForMinutes(int degrees, int minutes) {}

	public void bakeAtDegreesForMinutesUntilTexture(int degrees, int minutes,
			Texture texture) {}

	public Ingredient getContents() {
		return new Ingredient(product, 1, product);
	}
}

enum Texture {
	FLUFFY, BLENDED, STIFF_PEAKS, SET
}
