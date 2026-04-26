# 📍 BuscarCEP

Aplicação Java para consulta de CEP utilizando a API pública do ViaCEP, com conversão de dados JSON e geração de arquivos locais.

---

## 🚀 Objetivo

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de desenvolvimento backend em Java, incluindo:

* Consumo de APIs externas
* Manipulação de JSON com Gson
* Organização de código com Programação Orientada a Objetos (POO)
* Escrita de arquivos locais

---

## 🛠️ Tecnologias utilizadas

* Java 11+
* Gson (Google JSON Library)
* API ViaCEP
* `java.net.http.HttpClient`

---

## 📂 Estrutura do projeto

```
br.com.BuscarCEP
│
├── modelos
│   ├── Endereco.java          # Representa os dados do CEP
│   ├── ConsultaCep.java       # Responsável por consumir a API
│   ├── GeradorDeArquivo.java  # Responsável por salvar os dados em JSON
│
└── Main.java                  # Classe principal (entrada da aplicação)
```

---

## ⚙️ Como funciona

1. O usuário digita um CEP no terminal
2. A aplicação faz uma requisição para a API ViaCEP
3. Os dados são convertidos para um objeto Java (`Endereco`)
4. Um arquivo `.json` é gerado com as informações do CEP

---

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/RonaldHiedley/BuscarCEP.git
```

2. Abra o projeto em sua IDE (IntelliJ recomendado)

3. Execute a classe `Main`

4. Digite um CEP válido (ex: `01001000`)

---

## 📄 Exemplo de saída

Arquivo gerado:

```
01001000.json
```

Conteúdo:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

## ⚠️ Tratamento de erros

* CEP inválido ou erro na requisição → aplicação encerra com mensagem
* Falha ao salvar arquivo → exceção tratada

---

## 🧠 Conceitos aplicados

* Separação de responsabilidades (SRP)
* Consumo de API REST
* Serialização e desserialização JSON
* Manipulação de arquivos com `FileWriter`
* Uso de `try-with-resources`

---

## 🚧 Melhorias futuras

* Validação de CEP antes da requisição
* Tratamento de resposta da API (ex: `"erro": true`)
* Suporte a múltiplos CEPs
* Armazenamento em lista (`List<Endereco>`)
* Criação de API REST com Spring Boot
* Persistência em banco de dados (PostgreSQL)
* Testes automatizados (JUnit)

---

## 📌 Status do projeto

🟢 Em desenvolvimento — focado em aprendizado e evolução como desenvolvedor backend.

---

## 👨‍💻 Autor

Desenvolvido por Ronald Hiedley
GitHub: https://github.com/RonaldHiedley

---
