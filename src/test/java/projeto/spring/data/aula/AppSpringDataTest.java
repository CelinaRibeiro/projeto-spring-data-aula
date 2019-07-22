package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDateUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDateUser interfaceSpringDateUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();

		usuarioSpringData.setEmail("joanae@gamil.com");
		usuarioSpringData.setIdade(22);
		usuarioSpringData.setLogin("josi");
		usuarioSpringData.setSenha("adm3833");
		usuarioSpringData.setNome("Joana Maria");

		interfaceSpringDateUser.save(usuarioSpringData);

	}

	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDateUser.findById(2L);

		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getEmail());
	}

	@Test
	public void testeConsutaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDateUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------");
		}
	}

	@Test
	public void testeUpdate() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDateUser.findById(2L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setNome("Teste 2");
		data.setIdade(60);

		interfaceSpringDateUser.save(data);

	}

	@Test
	public void testeDelete() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDateUser.findById(6L);

		interfaceSpringDateUser.delete(usuarioSpringData.get());
	}

	@Test
	public void testeConsultaNome() {
		List<UsuarioSpringData> list = interfaceSpringDateUser.buscaPorNome("Teste");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------");
		}
	}
	
	@Test
	public void testeConsultaNomeParam() {
		UsuarioSpringData usuarioSpringData = interfaceSpringDateUser.buscaPorNomeParam("Teste");

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------");
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDateUser.deletePorNome("Teste");
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDateUser.findById(1L);
		
		Telefone telefone = new Telefone();
		
		telefone.setTipo("celular");
		telefone.setNumero("6288889689");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
				
		interfaceTelefone.save(telefone);
	}

}
