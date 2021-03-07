package nc.recipe.multiblock;

import static nc.config.NCConfig.*;

import java.util.*;

import nc.recipe.BasicRecipeHandler;

public class TurbineRecipes extends BasicRecipeHandler {
	
	public TurbineRecipes() {
		super("high_turbine", 0, 1, 0, 1);
	}
	
	@Override
	public void addRecipes() {
		addRecipe(fluidStack("high_pressure_steam", 1), fluidStack("exhaust_steam", 4), turbine_power_per_mb[0], turbine_expansion_level[0], "cloud", 1D / 23.2D);
		addRecipe(fluidStack("low_pressure_steam", 1), fluidStack("low_quality_steam", 2), turbine_power_per_mb[1], turbine_expansion_level[1], "cloud", 1D / 23.2D);
		addRecipe(fluidStack("steam", 1), fluidStack("low_quality_steam", 2), turbine_power_per_mb[2], turbine_expansion_level[2], "cloud", 1D / 23.2D);
	}
	
	@Override
	public List fixExtras(List extras) {
		List fixed = new ArrayList(4);
		fixed.add(extras.size() > 0 && extras.get(0) instanceof Double ? (double) extras.get(0) : 0D);
		fixed.add(extras.size() > 1 && extras.get(1) instanceof Double ? (double) extras.get(1) : 1D);
		fixed.add(extras.size() > 2 && extras.get(2) instanceof String ? (String) extras.get(2) : "cloud");
		fixed.add(extras.size() > 3 && extras.get(3) instanceof Double ? (double) extras.get(3) : 1D / 23.2D);
		return fixed;
	}
}
