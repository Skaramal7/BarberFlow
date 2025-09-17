Este aplicativo foi desenvolvido para a disciplina de Engenharia de Software do Bacharelado em Ciências da Computação na Universidade Federal de Uberlândia, no semestre 2025/1.
Este aplicativo está licenciado sob o copyleft GNU General License v3.0.

O aplicativo tem a ideia de ser o Minimum Viable Product (MVP) de um sistema de gerenciamento de barbearias, com três principais classes de usuários: Clientes, Barbeiros e Gerentes.
Foi desenvolvido em Kotlin pelo Android Studio, com o uso da biblioteca Compose.
O sistema completo pressupõe um gerenciamento de estados individual para cada barbearia, sendo cada barbearia representada pela classe BarberShop.
A inserção de gerentes deve ser realizada diretamente pela classe BarberShop, em um sistema de administração que seria implementado para que o dono ou gestor de mais alta patente da barbearia possa configurar corretamente seu uso.
Ademais, o sistema permite que clientes façam agendamentos com o seu barbeiro de preferência, escolhendo os serviços desejados (Corte, Barba, Sobrancela, etc.), permite que barbeiros consultem os agendamentos feitos consigo e cancelem-nos caso necessário, e permite que os gerentes adicionem clientes e barbeiros, verifiquem os agendamentos de cada barbeiro que gerencia e emita relatórios.
Além disso, cada agendamento gera um registro de pagamento, que é armazenado para a barbearia.
