package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto;

public class JugadaMapper {

	@Component
	public class SucursalMapper {

		public static SucursalDTO toSucursalDto(Sucursal sucursal) {
			Integer id = sucursal.getPk_SucursalID();
			String nombre = sucursal.getNombre();
			String pais = sucursal.getPais();
		
			return new SucursalDTO(id, nombre, pais);
		}

		public static Sucursal toSucursal(SucursalDTO sucursaldto) {
			return new Sucursal(sucursaldto.getName(), sucursaldto.getPais());
		}
		
		public static Sucursal updateSucursal(SucursalDTO sucursaldto) {
			return new Sucursal(sucursaldto.getId(),sucursaldto.getName(), sucursaldto.getPais());
		}
	}

}
