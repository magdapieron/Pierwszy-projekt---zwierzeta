package agh;

public interface IPositionChangeObserver {

	/**
	 * Delete pair <oldPosition, animal> from LinkedHashMap and add pair <newPosition, animal>
	 */
	
	void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
