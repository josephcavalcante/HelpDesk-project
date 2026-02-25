## UC01 — Cadastrar Usuário

# Ator principal: Visitante Objetivo: Criar uma conta de usuário no sistema. Pré-condições: Não estar autenticado. Pós-condições: Usuário criado e apto a realizar login.

# Fluxo principal:

1. # O visitante acessa a tela de cadastro.

2. # O sistema exibe formulário (nome, e-mail, senha, confirmar senha).

3. # O visitante preenche e envia o formulário.

4. # O sistema valida os dados.

5. # O sistema verifica se o e-mail já está cadastrado.

6. # O sistema salva o usuário com a senha armazenada em hash.

7. # O sistema confirma o cadastro e redireciona para a tela de login.

# Fluxos alternativos / exceções:

* # A1: Campos inválidos (vazios, e-mail inválido, senha fraca) → sistema informa erros e mantém formulário.

* # A2: E-mail já cadastrado → sistema informa e solicita outro e-mail.

# ---

## UC02 — Cadastrar Administrador

# Ator principal: Administrador (já existente) ou Sistema (configuração inicial) Objetivo: Criar uma conta com perfil de administrador. Pré-condições (opção 1): Administrador autenticado e com permissão de gerenciamento. Pré-condições (opção 2): Sistema em modo de bootstrap (primeiro administrador). Pós-condições: Administrador criado.

# Fluxo principal (opção 1 — por admin):

1. # O administrador acessa a área de administração.

2. # O sistema exibe opção “Cadastrar administrador”.

3. # O administrador preenche (nome, e-mail, senha, confirmar senha).

4. # O sistema valida os dados e verifica e-mail.

5. # O sistema cria usuário com papel ADMIN.

6. # O sistema confirma e registra no log.

# Fluxos alternativos / exceções:

* # A1: E-mail já cadastrado → sistema informa e não conclui.

* # A2: Sem permissão → sistema bloqueia acesso e registra tentativa.

* # A3: (bootstrap) Caso já exista um admin → sistema nega a criação por bootstrap.

# ---

## **UC03 — Login do Usuário**

# Ator principal: Usuário Objetivo: Autenticar-se no sistema como usuário comum. Pré-condições: Usuário cadastrado e não autenticado. Pós-condições: Sessão iniciada; usuário redirecionado para sua área.

# Fluxo principal:

1. # O usuário acessa a tela de login.

2. # O sistema exibe formulário (e-mail, senha).

3. # O usuário informa credenciais e envia.

4. # O sistema valida credenciais.

5. # O sistema inicia sessão do usuário.

6. # O sistema redireciona para “Meus Chamados”.

# Fluxos alternativos / exceções:

* # A1: Credenciais inválidas → sistema informa erro e permite nova tentativa.

* # A2: Conta inativa/bloqueada (se aplicável) → sistema impede login.

# ---

## **UC04 — Login do Administrador**

# Ator principal: Administrador Objetivo: Autenticar-se no sistema com perfil de administrador. Pré-condições: Admin cadastrado e não autenticado. Pós-condições: Sessão iniciada; admin redirecionado para painel geral.

# Fluxo principal:

1. # O administrador acessa a tela de login.

2. # Informa e-mail e senha.

3. # O sistema valida credenciais.

4. # O sistema verifica o papel ADMIN.

5. # O sistema inicia sessão.

6. # O sistema redireciona para “Chamados (geral)”.

# Fluxos alternativos / exceções:

* # A1: Credenciais inválidas → erro.

* # A2: Usuário sem papel ADMIN tenta acessar área admin → sistema nega e redireciona.

# ---

## **UC05 — Cadastrar Novo Chamado (Usuário)**

# Ator principal: Usuário Objetivo: Abrir um novo chamado de suporte. Pré-condições: Usuário autenticado. Pós-condições: Chamado criado com status ABERTO.

# Fluxo principal:

1. # O usuário acessa “Novo chamado”.

2. # O sistema exibe formulário (título, descrição, categoria, prioridade opcional).

3. # O usuário preenche e envia.

4. # O sistema valida os dados.

5. # O sistema registra o chamado como ABERTO, associado ao usuário.

6. # O sistema confirma e redireciona para detalhes do chamado.

# Fluxos alternativos / exceções:

* # A1: Campos obrigatórios não preenchidos → sistema informa e não cria.

* # A2: Categoria inexistente/indisponível → sistema informa.

# ---

## **UC06 — Listar Chamados Abertos por Mim (Usuário)**

# Ator principal: Usuário Objetivo: Visualizar os chamados do próprio usuário, com foco nos abertos. Pré-condições: Usuário autenticado. Pós-condições: Lista exibida.

# Fluxo principal:

1. # Usuário acessa “Meus chamados”.

2. # O sistema consulta chamados do usuário.

3. # O sistema aplica filtro padrão status \= ABERTO (ou permite selecionar).

4. # O sistema exibe lista paginada (número, título, status, data).

# Fluxos alternativos / exceções:

* # A1: Nenhum chamado encontrado → sistema exibe mensagem “Nenhum chamado aberto”.

# ---

## **UC07 — Listar Chamados (Geral) — Administrador**

# Ator principal: Administrador Objetivo: Visualizar todos os chamados do sistema. Pré-condições: Administrador autenticado. Pós-condições: Lista geral exibida.

# Fluxo principal:

1. # Admin acessa “Chamados (geral)”.

2. # O sistema consulta todos os chamados.

3. # O sistema exibe lista com filtros (status, categoria, usuário, período).

4. # Admin pode ordenar/paginar.

# Fluxos alternativos / exceções:

* # A1: Sem permissão → acesso negado.

# ---

## **UC08 — Ver Detalhes do Chamado**

# Atores principais: Usuário / Administrador Objetivo: Visualizar informações completas de um chamado. Pré-condições: Autenticado. Regras de acesso:

* # Usuário só pode ver chamados próprios.

* # Admin pode ver qualquer chamado.   Pós-condições: Detalhes exibidos.

# Fluxo principal:

1. # Ator seleciona um chamado na listagem.

2. # O sistema verifica permissão de acesso ao chamado.

3. # O sistema exibe detalhes: título, descrição, status, histórico, comentários, datas.

# Fluxos alternativos / exceções:

* # A1: Chamado inexistente → 404\.

* # A2: Sem permissão → 403 (ou redireciona com mensagem).

# ---

## **UC09 — Atualizar Chamado (Adicionar Comentário e/ou Mudar Status)**

# Atores principais: Usuário / Administrador Objetivo: Registrar interação no chamado (comentário) e/ou alterar status. Pré-condições: Autenticado e com permissão sobre o chamado (UC08). Pós-condições: Chamado atualizado, histórico registrado.

## **UC09-A — Adicionar comentário**

# Fluxo principal:

1. # Ator acessa detalhes do chamado.

2. # Informa comentário e envia.

3. # O sistema valida (não vazio, limite de caracteres).

4. # O sistema salva comentário vinculado ao chamado e ao autor.

5. # O sistema confirma e mantém na tela de detalhes.

# Exceções:

* # A1: Comentário vazio/maior que o limite → erro.

### UC09-B — Mudar status

# Regras sugeridas:

* # Usuário: pode alterar para CANCELADO (opcional) ou reabrir (se permitido).

* # Admin: pode alterar para EM ANDAMENTO e RESOLVIDO e REABERTO.

# Fluxo principal (admin):

1. # Admin acessa detalhes.

2. # Seleciona novo status e confirma.

3. # Sistema valida transição de status.

4. # Sistema atualiza status e registra no histórico (quem, quando, de→para).

5. # Sistema confirma.

# Exceções:

* # A1: Transição inválida (ex.: resolvido → em andamento sem reabrir) → sistema bloqueia.

* # A2: Usuário tenta alterar status não permitido → acesso negado.


## **UC09-A — Adicionar comentário**

# Fluxo principal:

6. # Ator acessa detalhes do chamado.

7. # Informa comentário e envia.

8. # O sistema valida (não vazio, limite de caracteres).

9. # O sistema salva comentário vinculado ao chamado e ao autor.

10. # O sistema confirma e mantém na tela de detalhes.

# **UC10 — Alterar Perfil**

**Ator principal:** Usuário  
**Objetivo:** Permitir que o usuário altere seus dados cadastrais e inclua/atualize sua foto de perfil.  
 **Pré-condições:**

* Usuário autenticado (RN03).

**Pós-condições:**

* Dados atualizados no sistema.  
* Nova foto armazenada (se enviada).

---

## **Fluxo Principal**

1. O usuário acessa a opção “Meu Perfil”.  
2. O sistema exibe formulário contendo:

   * Nome  
   * E-mail  
   * Foto atual  
   * Campo para upload de nova foto

3. O usuário altera os dados desejados.  
4. O usuário seleciona uma nova foto (opcional).  
5. O usuário confirma a operação.  
6. O sistema valida:

   * Campos obrigatórios.  
   * Unicidade do e-mail (RN01).  
   * Tipo e tamanho da imagem (RN17).

7. O sistema salva as alterações.  
8. O sistema armazena a foto com nome seguro (RN18).  
9. O sistema exibe mensagem de sucesso.

---

## **Fluxos Alternativos / Exceções**

**A1 — E-mail já cadastrado**  
 → Sistema informa erro e não salva alterações (RN01).

**A2 — Arquivo inválido (formato ou tamanho)**  
 → Sistema informa erro e mantém dados anteriores (RN17).

**A3 — Usuário não autenticado**  
 → Sistema redireciona para login (RN03).

---

## **Regras de Negócio Aplicáveis**

RN01, RN03, RN16, RN17, RN18.

---

# **UC11 — Alterar Senha**

**Ator principal:** Usuário  
**Objetivo:** Permitir que o usuário altere sua senha estando autenticado.  
**Pré-condições:**

* Usuário autenticado (RN03).

**Pós-condições:**

* Nova senha armazenada como hash (RN02).

---

## **Fluxo Principal**

1. O usuário acessa “Alterar Senha”.

2. O sistema exibe formulário contendo:

   * Senha atual

   * Nova senha

   * Confirmação da nova senha

3. O usuário preenche os campos e confirma.

4. O sistema valida:

   * Se a senha atual está correta (RN19).

   * Se a nova senha atende critérios mínimos (RN20).

   * Se nova senha e confirmação coincidem.

5. O sistema gera novo hash da senha (RN02).

6. O sistema atualiza o registro do usuário.

7. O sistema exibe mensagem de sucesso.

---

## **Fluxos Alternativos / Exceções**

**A1 — Senha atual incorreta**  
 → Sistema informa erro e não altera.

**A2 — Nova senha inválida**  
 → Sistema informa critérios mínimos (RN20).

**A3 — Confirmação diferente da nova senha**  
 → Sistema informa inconsistência.

---

## **Regras de Negócio Aplicáveis**

RN02, RN03, RN19, RN20.

---

# **UC12 — Recuperar Senha**

**Ator principal:** Usuário (não autenticado)  
**Objetivo:** Permitir redefinição de senha mediante token temporário.  
**Pré-condições:**

* Usuário cadastrado no sistema.  
* Não estar autenticado.

**Pós-condições:**

* Senha redefinida com sucesso.  
* Token invalidado.

---

## **Parte A — Solicitar recuperação**

### **Fluxo Principal**

1. O usuário acessa “Esqueci minha senha”.  
2. O sistema solicita o e-mail.  
3. O usuário informa o e-mail e confirma.  
4. O sistema verifica se o e-mail está cadastrado.  
5. O sistema gera token único e temporário (RN21).  
6. O sistema registra token com tempo de expiração (RN22).  
7. O sistema envia link de redefinição (em aula pode ser exibido no console).  
8. O sistema exibe mensagem: “Se o e-mail existir, enviaremos instruções”.

### **Fluxos Alternativos**

**A1 — E-mail não cadastrado**  
 → Sistema não informa explicitamente (por segurança), apenas exibe mensagem genérica.

---

## **Parte B — Redefinir senha via token**

### **Fluxo Principal**

1. O usuário acessa link contendo token.

2. O sistema valida:

   * Existência do token.  
   * Validade temporal (RN22).  
   * Se não foi utilizado (RN23).

3. O sistema exibe formulário:

   * Nova senha  
   * Confirmação

4. O usuário preenche e envia.  
5. O sistema valida nova senha (RN20).  
6. O sistema gera novo hash (RN02).  
7. O sistema invalida o token (RN23).  
8. O sistema confirma redefinição.  
9. O sistema redireciona para login.

---

## **Fluxos Alternativos / Exceções**

**B1 — Token inválido ou expirado**  
 → Sistema exibe mensagem e solicita nova recuperação.

**B2 — Senha inválida**  
 → Sistema informa critérios mínimos.

---

## **Regras de Negócio Aplicáveis**

RN02, RN20, RN21, RN22, RN23.

# **1\) Regras de Negócio (RN) — Gerais e por Caso de Uso**

## **RN — Autenticação, autorização e conta**

**RN01.** O e-mail do usuário deve ser **único** no sistema.  
**RN02.** A senha deve ser armazenada **apenas como hash** (nunca em texto puro).  
**RN03.** Usuário só pode acessar telas protegidas se estiver **autenticado**.  
**RN04.** Administrador deve possuir papel **ADMIN** para acessar área administrativa.  
**RN05.** Usuário comum **não** pode acessar listagem geral nem ações administrativas.  
**RN06.** Sessões devem expirar por **inatividade** (ex.: 30 min) e permitir logout.  
**RN07.** Tentativas de login inválidas podem ser limitadas (ex.: 5 tentativas) *(opcional)*.

## **RN — Chamados e permissões**

**RN08.** Um chamado deve ter: título, descrição, categoria e status.  
**RN09.** Ao criar, o chamado nasce com status **ABERTO**.  
**RN10.** Usuário comum só pode visualizar/alterar chamados **próprios**.  
**RN11.** Administrador pode visualizar/alterar **qualquer** chamado.  
**RN12.** Toda mudança relevante (comentário/status) deve gerar **registro de histórico**.  
**RN13.** Comentários não podem ser vazios e devem respeitar limite de caracteres (ex.: 1–1000).  
**RN14.** Status permitidos: **ABERTO, EM\_ANDAMENTO, RESOLVIDO, CANCELADO, REABERTO** (você pode simplificar).  
**RN15.** Transições de status devem ser validadas (ver RN específicas abaixo).

## **RN — Perfil, foto e senha**

**RN16.** Usuário pode alterar dados de perfil (nome, e-mail etc.), respeitando RN01.  
**RN17.** Foto de perfil deve aceitar apenas formatos permitidos (ex.: JPG/PNG) e tamanho máximo (ex.: 2MB).  
**RN18.** Foto deve ser armazenada com nome seguro e sem permitir path traversal.  
**RN19.** Alteração de senha exige confirmação da senha atual (exceto recuperação).  
**RN20.** Nova senha deve atender critérios mínimos (ex.: 8 caracteres \+ letras/números).  
**RN21.** Recuperação de senha deve usar token **temporário** e **de uso único**.  
**RN22.** Token expira em tempo curto (ex.: 30–60 min).  
**RN23.** Ao redefinir senha via token, o token deve ser invalidado imediatamente.

---

# **2\) Casos de Uso (UC) — com RN associadas**

## **UC01 — Cadastrar Usuário**

**Ator:** Visitante  
**Objetivo:** Criar conta de usuário.  
**Pré:** Não autenticado.  
**Pós:** Conta criada.

**Fluxo principal:**

1. Acessa “Criar conta”.  
2. Preenche nome, e-mail, senha, confirmação.  
3. Sistema valida e cria usuário.  
4. Sistema redireciona para login.

**RNs aplicáveis:** RN01, RN02, RN20.

---

## **UC02 — Cadastrar Administrador**

**Ator:** Administrador (ou bootstrap inicial)  
**Objetivo:** Criar conta ADMIN.  
**Pré:** Admin autenticado **ou** modo bootstrap.  
**Pós:** Admin criado.

**Fluxo principal:**

1. Admin acessa “Usuários” → “Novo Admin”.  
2. Preenche dados.  
3. Sistema valida e cria admin (papel ADMIN).

**RNs:** RN01, RN02, RN04, RN05.

---

## **UC03 — Login do Usuário**

**Ator:** Usuário  
**Objetivo:** Autenticar usuário comum.  
**Pré:** Usuário cadastrado.  
**Pós:** Sessão iniciada.

**RNs:** RN02, RN03, RN06, RN07.

---

## **UC04 — Login do Administrador**

**Ator:** Administrador  
**Objetivo:** Autenticar admin.  
**Pós:** Sessão iniciada com perfil ADMIN.

**RNs:** RN02, RN03, RN04, RN06, RN07.

---

## **UC05 — Cadastrar Novo Chamado (Usuário)**

**Ator:** Usuário  
**Objetivo:** Abrir chamado.  
**Pré:** Autenticado.  
**Pós:** Chamado criado como ABERTO.

**RNs:** RN03, RN08, RN09.

---

## **UC06 — Listar Chamados Abertos por Mim (Usuário)**

**Ator:** Usuário  
**Objetivo:** Ver seus chamados (padrão: abertos).  
**Pré:** Autenticado.

**RNs:** RN03, RN10.

---

## **UC07 — Listar Chamados Geral (Admin)**

**Ator:** Administrador  
**Objetivo:** Ver todos os chamados.  
**Pré:** ADMIN autenticado.

**RNs:** RN03, RN04, RN11.

---

## **UC08 — Ver Detalhes do Chamado**

**Atores:** Usuário / Admin  
**Objetivo:** Ver detalhes, histórico e comentários.  
**Regras de acesso:** Usuário só vê o próprio; admin vê todos.

**RNs:** RN03, RN10, RN11, RN12.

---

## **UC09 — Atualizar Chamado (Comentário e/ou Status)**

**Atores:** Usuário / Admin  
**Objetivo:** Interagir com o chamado.  
**Pré:** Ter acesso ao chamado (UC08).  
**Pós:** Chamado/histórico atualizado.

### **UC09-A — Adicionar comentário**

**RNs:** RN12, RN13.

### **UC09-B — Mudar status**

**Regras de transição (sugestão simples):**

* **RN24.** ABERTO → EM\_ANDAMENTO (admin)  
* **RN25.** EM\_ANDAMENTO → RESOLVIDO (admin)  
* **RN26.** RESOLVIDO → REABERTO (admin; usuário opcional)  
* **RN27.** ABERTO/EM\_ANDAMENTO → CANCELADO (usuário dono ou admin)  
* **RN28.** Se CANCELADO, não permite EM\_ANDAMENTO/RESOLVIDO (só reabrir via admin, se quiser).

**RNs:** RN10, RN11, RN12, RN14, RN15, RN24–RN28.

---

## **UC10 — Alterar Perfil (Usuário)**

**Ator:** Usuário  
**Objetivo:** Alterar dados (ex.: nome, e-mail) e incluir foto.  
**Pré:** Autenticado.  
**Pós:** Perfil atualizado.

**Fluxo principal:**

1. Usuário acessa “Meu perfil”.  
2. Edita campos e (opcional) anexa foto.  
3. Sistema valida e salva.  
4. Sistema confirma.

**RNs:** RN03, RN01, RN16, RN17, RN18.

---

## **UC11 — Alterar Senha (Usuário)**

**Ator:** Usuário  
**Objetivo:** Trocar senha com segurança.  
**Pré:** Autenticado.  
**Pós:** Senha atualizada.

**Fluxo principal:**

1. Usuário acessa “Alterar senha”.  
2. Informa senha atual \+ nova senha \+ confirmação.  
3. Sistema valida senha atual, valida nova, salva hash.  
4. Confirma alteração.

**RNs:** RN03, RN02, RN19, RN20.

---

## **UC12 — Recuperar Senha**

**Ator:** Visitante (usuário que esqueceu)  
**Objetivo:** Redefinir senha via token.  
**Pré:** Não autenticado.  
**Pós:** Senha redefinida, token invalidado.

**Fluxo principal:**

1. Usuário acessa “Esqueci minha senha”.  
2. Informa e-mail.  
3. Sistema gera token e registra expiração.  
4. Sistema “envia” link (em aula pode mostrar na tela/log).  
5. Usuário abre link e define nova senha.  
6. Sistema valida token, salva nova senha, invalida token.

**RNs:** RN02, RN21, RN22, RN23, RN20.

---

# **3\) Protótipos das telas (wireframes textuais)**

## **T01 — Home (pública)**

\+-------------------------------------------+  
| HELP DESK                                 |  
| \[Entrar\] \[Criar conta\]                    |  
|-------------------------------------------|  
| Bem-vindo\!                                |  
| Abra e acompanhe seus chamados.           |  
|                                           |  
| \[Entrar\]   \[Criar conta\]                  |  
\+-------------------------------------------+

## **T02 — Cadastro de Usuário (UC01)**

\+------------------ Criar conta \------------+  
| Nome:        \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
| E-mail:      \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
| Senha:       \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
| Confirmar:   \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
|                                          |  
| \[Criar conta\]                             |  
| Já tem conta? \[Entrar\]                    |  
\+------------------------------------------+

## **T03 — Login (UC03/UC04)**

\+--------------------- Login \---------------+  
| E-mail:  \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]           |  
| Senha:   \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]           |  
| \[Entrar\]                                  |  
| \[Esqueci minha senha\]                     |  
\+------------------------------------------+

## **T04 — Recuperar Senha (solicitar e-mail) (UC12)**

\+--------------- Recuperar senha \-----------+  
| Informe seu e-mail:                       |  
| E-mail: \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]            |  
| \[Enviar link de recuperação\]              |  
| \[Voltar ao login\]                         |  
\+------------------------------------------+

## **T05 — Redefinir senha (via token) (UC12)**

\+------------- Redefinir senha \-------------+  
| Nova senha:      \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]     |  
| Confirmar senha: \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]     |  
| \[Salvar nova senha\]                        |  
\+------------------------------------------+

## **T06 — Layout base (autenticado)**

\+------------------------------------------------+  
| HELP DESK | Olá, \<nome\>                         |  
| \[Meus chamados\] \[Novo chamado\] \[Perfil\] \[Sair\]  |  
\+------------------------------------------------+  
| (conteúdo da página)                            |  
\+------------------------------------------------+

## **T07 — Meus Chamados (UC06)**

\+------------------- Meus chamados \--------------+  
| Filtro: \[Abertos v\]  Buscar: \[\_\_\_\_\_\_\_\_\_\_\] \[OK\] |  
|------------------------------------------------|  
| \#   Título                 Status     Data     |  
| 12  "Erro no acesso"       ABERTO     10/02    |  
| 15  "Reset de senha"       EM\_AND.    11/02    |  
|------------------------------------------------|  
| \[Ver\] em cada linha                             |  
| Página: \< 1 2 3 \>                               |  
\+------------------------------------------------+

## **T08 — Novo Chamado (UC05)**

\+------------------- Novo chamado \---------------+  
| Título:     \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
| Categoria:  \[Suporte Técnico v\]                |  
| Prioridade: \[Média v\]                          |  
| Descrição:  \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
|             \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
|             \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]       |  
| \[Abrir chamado\]  \[Cancelar\]                    |  
\+------------------------------------------------+

## **T09 — Detalhes do Chamado (UC08 \+ UC09)**

\+----------------- Chamado \#12 \------------------+  
| Título: Erro no acesso                         |  
| Status: ABERTO        Categoria: Suporte       |  
| Prioridade: Média     Criado em: 10/02         |  
|------------------------------------------------|  
| Descrição:                                      |  
| "Ao tentar entrar, aparece..."                  |  
|------------------------------------------------|  
| Histórico / Comentários                         |  
| \- 10/02  Juliana: "Detalhei o erro..."          |  
| \- 11/02  Admin: "Em análise."                   |  
|------------------------------------------------|  
| Adicionar comentário:                           |  
| \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]   |  
| \[Enviar comentário\]                             |  
|------------------------------------------------|  
| (Admin) Alterar status: \[EM\_ANDAMENTO v\] \[OK\]  |  
\+------------------------------------------------+

## **T10 — Chamados (Geral) Admin (UC07)**

\+----------------- Chamados (Admin) \------------+  
| Status: \[Todos v\] Categoria: \[Todas v\]         |  
| Usuário: \[\_\_\_\_\_\_\_\_\_\_\] Período: \[\_\_/\_\_ \- \_\_/\_\_\] |  
| \[Filtrar\]                                      |  
|------------------------------------------------|  
| \#  Usuário     Título              Status      |  
| 12 Juliana     Erro no acesso      ABERTO      |  
| 13 Pedro       Impressora          RESOLVIDO   |  
|------------------------------------------------|  
| \[Ver\] em cada linha                             |  
\+------------------------------------------------+

## **T11 — Perfil (UC10)**

\+------------------- Meu perfil \-----------------+  
| Nome:   \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                 |  
| E-mail: \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                 |  
| Foto atual: (imagem)                           |  
| Nova foto: \[Escolher arquivo\]                  |  
| \[Salvar alterações\]                            |  
\+------------------------------------------------+

## **T12 — Alterar Senha (UC11)**

\+----------------- Alterar senha \----------------+  
| Senha atual:     \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]        |  
| Nova senha:      \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]        |  
| Confirmar nova:  \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]        |  
| \[Salvar nova senha\]                            |  
\+------------------------------------------------+

## **T13 — Admin: Cadastrar Administrador (UC02)**

\+-------------- Novo Administrador \--------------+  
| Nome:   \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                 |  
| E-mail: \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                 |  
| Senha:  \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                 |  
| Confirmar: \[\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\]                |  
| \[Cadastrar admin\]                              |  
\+------------------------------------------------+

---

Se você quiser, eu também posso te entregar:

* uma **tabela “Tela x Caso de Uso x Rotas Flask (GET/POST)”** (muito boa para guiar as aulas);  
* e um **mapa da estrutura de pastas Flask** (blueprints, templates, static, forms, models) para a turma seguir.

