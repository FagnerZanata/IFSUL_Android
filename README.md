# MyApp

Um aplicativo Android para cadastro de alunos, demonstrando o uso de componentes de interface modernos e validações de formulário.

## 🚀 Funcionalidades

- **Cadastro de Alunos**: Formulário completo para inserção de dados.
- **Validações em Tempo Real**: Verificação de campos obrigatórios, formato de e-mail, telefone, CEP e força de senha.
- **Componentes Material Design**: Uso de `ChipGroup` para seleção de status e `MaterialComponents` para uma interface moderna.
- **Layouts Flexíveis**: Implementação utilizando `LinearLayout` (Scroll) e exemplos de `ConstraintLayout`.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: [Kotlin](https://kotlinlang.org/)
- **Interface**: XML (Android View System) com [Material Components](https://github.com/material-components/material-components-android)
- **Min SDK**: 24
- **Target SDK**: 36
- **Gradle**: Kotlin DSL (`build.gradle.kts`)

## 📦 Estrutura do Projeto

- `MainActivity.kt`: Lógica principal de validação e interação com o formulário.
- `activity_main.xml`: Layout principal contendo o formulário de cadastro.
- `themes.xml`: Configuração de temas (Material Design).

## 🔧 Como Executar

1. Clone o repositório.
2. Abra o projeto no **Android Studio**.
3. Sincronize o Gradle.
4. Execute o aplicativo em um emulador ou dispositivo físico com Android 7.0 (API 24) ou superior.

## 📝 Notas de Versão

### v1.0.0
- Implementação inicial do formulário de cadastro.
- Correção de erro de inflação de componentes Material Design (ajuste de tema).
- Adição de validações básicas de formulário.
