package Simple.Warehouse.Project;

public class SingleSpace implements WarehouseSpace {
	
	 private char productCode = '.';  // Default value for empty space.

	@Override
	public boolean isOccupied() {
		 return productCode != '.';
	}

	@Override
	public char getProductCode() {
		return productCode;
	}

	@Override
	public void setProductCode(char productCode) {
		this.productCode = productCode;
		
	}

}
