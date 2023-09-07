package Simple.Warehouse.Project;

import java.util.Scanner;

public class Warehouse {
	
	   private WarehouseSpace[][] grid;

	    public Warehouse() {
	    }

	    public void init(int width, int height) {
	        grid = new SingleSpace[height][width];
	        for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                grid[i][j] = new SingleSpace();
	            }
	        }
	    }

	    public boolean store(int x, int y, int w, int h, char productCode) {
	        if (x + w > grid[0].length || y + h > grid.length) return false;
	        for (int i = y; i < y + h; i++) {
	            for (int j = x; j < x + w; j++) {
	                if (grid[i][j].isOccupied()) return false;
	                grid[i][j].setProductCode(productCode);
	            }
	        }
	        return true;
	    }

	    public boolean remove(int x, int y) {
	        if (x >= grid[0].length || y >= grid.length || !grid[y][x].isOccupied()) return false;
	        char productCode = grid[y][x].getProductCode();
	       
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[i].length; j++) {
	                if (grid[i][j].getProductCode() == productCode) {
	                    grid[i][j].setProductCode('.');
	                }
	            }
	        }
	        return true;
	    }

	    public void view() {
	        for (int i = grid.length - 1; i >= 0; i--) {
	            for (int j = 0; j < grid[i].length; j++) {
	                System.out.print(grid[i][j].getProductCode() + " ");
	            }
	            System.out.println();
	        }
	    }

	    public void locate(char productCode) {
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[i].length; j++) {
	                if (grid[i][j].getProductCode() == productCode) {
	                    System.out.println("(" + j + ", " + i + ")");
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Warehouse warehouse = new Warehouse();

	        while (true) {
	            System.out.print("> ");
	            String[] inputs = sc.nextLine().split(" ");
	            switch (inputs[0].toLowerCase()) {
	                case "help":
	                    System.out.println("Commands:\nhelp: Shows help\ninit W H: Initializes warehouse\nstore X Y W H P: Stores crate\nlocate P: Locate product\nremove X Y: Removes crate\nview: Views warehouse\nexit: Exits");
	                    break;
	                case "init":
	                    int width = Integer.parseInt(inputs[1]);
	                    int height = Integer.parseInt(inputs[2]);
	                    warehouse.init(width, height);
	                    break;
	                case "store":
	                    int x = Integer.parseInt(inputs[1]);
	                    int y = Integer.parseInt(inputs[2]);
	                    int w = Integer.parseInt(inputs[3]);
	                    int h = Integer.parseInt(inputs[4]);
	                    char p = inputs[5].charAt(0);
	                    warehouse.store(x, y, w, h, p);
	                    break;
	                case "locate":
	                    char product = inputs[1].charAt(0);
	                    warehouse.locate(product);
	                    break;
	                case "remove":
	                    int rx = Integer.parseInt(inputs[1]);
	                    int ry = Integer.parseInt(inputs[2]);
	                    warehouse.remove(rx, ry);
	                    break;
	                case "view":
	                    warehouse.view();
	                    break;
	                case "exit":
	                    sc.close();
	                    return;
	                default:
	                    System.out.println("Invalid command. Type 'help' for a list of commands.");
	            }
	        }
	    }
	

}
