package aulapratica.controller;

import aulapratica.model.Pedido;
import aulapratica.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class RegistroPedidoController {

	private final PedidoRepository pedidoRepository;

	public RegistroPedidoController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.findById(pedidoSalvo.getId()).get());
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> listarTodos() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> consultarPorId(@PathVariable Long id) {
		return pedidoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (!pedidoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		pedidoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
