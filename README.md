# Sistema de Cadastro e Visualização de Clientes

## Levantamento e Documentação de Requisitos

### Requisitos Funcionais:

1. **Cadastro de Clientes:**
   - O sistema deve permitir o cadastro de clientes.
   - Para cadastrar um cliente, é necessário fornecer: Código, Nome e CNPJ.
   - O cliente deve ter um endereço associado ao seu cadastro.
   - O endereço do cliente deve incluir informações de localização geográfica.
   - Não é possível cadastrar um cliente sem fornecer todas as informações obrigatórias.
   
2. **Armazenamento Geográfico:**
   - As informações de localização geográfica dos clientes devem ser armazenadas de forma precisa.
   - Deve ser possível visualizar a localização dos clientes em um mapa.

### Requisitos Não Funcionais:

1. **Segurança:**
   - O sistema deve garantir a segurança dos dados dos clientes.
   - Deve ser implementado um sistema de autenticação e controle de acesso para proteger as informações.
   
2. **Desempenho:**
   - O sistema deve ser eficiente e responsivo, mesmo com grandes volumes de dados.
   - As consultas ao banco de dados devem ser otimizadas para garantir tempos de resposta rápidos.
   
3. **Usabilidade:**
   - A interface do usuário deve ser intuitiva e de fácil utilização.
   - Os usuários devem ser capazes de realizar as tarefas com pouca ou nenhuma orientação.

## Regras de Negócio:

1. **Cadastro de Clientes:**
   - Todos os campos obrigatórios devem ser preenchidos para cadastrar um cliente.
   - O CNPJ fornecido deve ser único no sistema.
   - O cliente só pode ser cadastrado se houver um endereço associado a ele.
   
2. **Armazenamento Geográfico:**
   - A localização geográfica deve ser precisa o suficiente para permitir entregas no local exato.


## Plano de Teste:

### Casos de Teste:

1. **Cadastro de Clientes:**
   - Testar o cadastro de um novo cliente com todas as informações corretas.
   - Tentar cadastrar um cliente sem preencher todos os campos obrigatórios.
   - Tentar cadastrar um cliente com um CNPJ já existente no sistema.

2. **Armazenamento Geográfico:**
   - Verificar se as informações de localização geográfica estão sendo armazenadas corretamente para cada cliente.
   - Testar a precisão da localização geográfica em diferentes casos de endereços.


### Estratégia de Teste:

- **Testes de Unidade:** Para verificar a funcionalidade de cada componente individualmente.
- **Testes de Integração:** Para garantir que todos os componentes se integrem corretamente.
- **Testes de Aceitação:** Para validar se o sistema atende aos requisitos do usuário final.
- **Testes de Desempenho:** Para avaliar o desempenho do sistema sob diferentes cargas de trabalho.

  ## Instruções de Build da Aplicação:

1. **Clonagem do Repositório:**
   - Clone este repositório em sua máquina local usando o comando:
     ```
     git clone https://github.com/seu-usuario/nome-do-repositorio.git
     ```

2. **Instalação de Dependências:**
   - Navegue até o diretório do projeto e instale as dependências usando o gerenciador de pacotes de sua preferência. Por exemplo, usando npm:
     ```
     cd nome-do-repositorio
     npm install
     ```

3. **Compilação e Execução:**
   - Após a instalação das dependências, compile e execute a aplicação.
   
4. **Acesso à Aplicação:**
   - Acesse a aplicação através do Postman utilizando o endereço local URL fornecido após a execução para fazer as chamadas de acordo com as necessedades.

