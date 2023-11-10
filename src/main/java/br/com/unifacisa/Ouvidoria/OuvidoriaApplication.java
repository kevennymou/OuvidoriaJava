package br.com.unifacisa.Ouvidoria;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unifacisa.Ouvidoria.entities.Aluno;
import br.com.unifacisa.Ouvidoria.entities.Person;
import br.com.unifacisa.Ouvidoria.entities.Ocorrencia;
import br.com.unifacisa.Ouvidoria.service.PersonService;
import br.com.unifacisa.Ouvidoria.util.Teclado;

@SpringBootApplication
public class OuvidoriaApplication implements CommandLineRunner {

	@Autowired
	PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("**Bem Vindo ao Sistema de Ouvidoria da Unifacisa**");
		System.out.println();
		
		boolean verificar = true;
		boolean condUSER = false;
		boolean condADM = false;
		
		while (verificar == true) {
			
			System.out.println("Qual opcao voce deseja? \n1-) Cadastrar \n2-) Login \n3-) Sair");
			String entrar = Teclado.texto();
			
			if (entrar.equals("1")) {
				System.out.println("Digite seu nome");
				String name = Teclado.texto();
				System.out.println("Digite seu email");
				String email = Teclado.texto();
				
				if (Person.verificarAluno(email) != true) {
					Aluno usuario = new Aluno(null, name, email);
					personService.addPerson(usuario);
					System.out.println("Usuario Cadastrado!");
					System.out.println("");
					
				} else {
					System.out.println("Usuario existente");
					System.out.println();
					
				}		
					
			} else if (entrar.equals("2")) {
				System.out.println("Logar com: \n1-) Aluno  \n2-) Professor  \n3-) Voltar");
				String entrar1 = Teclado.texto();
				
				if (entrar1.equals("1")) {
					System.out.println("Digite seu nome: ");
					String name = Teclado.texto();
					System.out.println("Digite seu email: ");
					String email = Teclado.texto();
					
					if (personService.retornarPerson(name, email) != null) {
						Person aluno = personService.retornarPerson(name, email);
						condUSER = true;
						
					} else {
						System.out.println("Usuario nao encontrado!");
						
					}
					
				} else if (entrar1.equals("2")) {
					System.out.println("Digite seu nome");
					String name = Teclado.texto();
					System.out.println("Digite seu email");
					String email = Teclado.texto();
					
					if (PersonService.verificarAdmin(name, email)) {
						condADM = true;
					} else {
						System.out.println("Nao localizado");
					}
				}
				
			} else if (entrar.equals("3")) {
				System.out.println("Obrigado");
				Teclado.FecharScanner();
				verificar = false;
			}
	
			Teclado.texto();
		
					while (condADM == true) {
						System.out.println("Menu do Professor: ");
						System.out.println();
						System.out.println(
								"\n1-) Excluir Ocorrencia \n2-) Listar Alunos \n3-) Listar Ocorrencia \n4-) Sair");
						System.out.print("Digite sua opcao: ");
						int entra = Teclado.inte();
				
						switch (entra) {
				
						case 1:
							System.out.println("1- Excluir todas \n2- Excluir especificas ");
							String excluir  = Teclado.texto();
							if (excluir.equals("1")) {
								if (personService.listarManifestacao()) {
									System.out.println();
									break;
							
								}
								
								System.out.println(personService.listarManifestacao());
								personService.deleteAll();
								System.out.println();
								break;
						
							} else if (excluir.equals("2")) {
								if (personService.listarManifestacao());
								System.out.println("Nao ha ocorrencias");
								System.out.println();
								break;
							}
					
							System.out.println(personService.listarManifestacao());
							System.out.println("Escolha a que ira deletar: ");
							String excluir1  = Teclado.texto();
							personService.deleteManifest(excluir1);
							System.out.println("Deletado!");
							break;
				
						case 2:
							System.out.println(personService.listarTodos());
							break;
					
						case 3:
							if(personService.listarManifestacao());
							System.out.println("Nao ha ocorrencias");
							System.out.println();
							break;
				
						case 4:
							condADM = false;
					
							break;
						
						default:
					
							break;
						} 
				
				while (condUSER == true) {
					System.out.println("**Bem vindo ao Sistema de Ouvidoria**");
					System.out.println();
					System.out.println("Menu do Sistema: ");
					System.out.println();
					System.out.println("1-) Cadastrar solicitacoes" + "\n2-) Listar manifestacao " + "\n3-) Sair");
					System.out.print("Digite sua opcao: ");
					String opcao = Teclado.texto();
					
					if (opcao.equals("1")) {
						System.out.println();
						System.out.println("1- Reclamacao \n3- Voltar");
						System.out.print("Digite sua opcao: ");
						String solicitar = Teclado.texto();
						Teclado.FecharScanner();
						
						switch (solicitar) {
						
						case "1":
							System.out.println();
							System.out.println("Digite sua ocorrencia");
							String opt = Teclado.texto();
							Ocorrencia ocorrencia = new Ocorrencia(null, opt);
							personService.addManifest(ocorrencia);
							System.out.println("Sua ocorrencia foi adicionada");
							System.out.println();
							break;
							
						default:
							
							break;
												
						}
							
					} else if (opcao.equals("2")) {
						if (personService.listarManifestacao());
						System.out.println();
						System.out.println("Nao ha ocorrencias");
						
					} else if (opcao.equals("3")) {
						condUSER = false;
					}
					
				}
					
			
			}
		
		}
			
	}
}
