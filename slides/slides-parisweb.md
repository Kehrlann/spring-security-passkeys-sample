---
theme: default
class: "text-center"
highlighter: prism
lineNumbers: true
transition: none
# use UnoCSS
css: unocss
aspectRatio: "16/9"
colorSchema: "light"
canvasWidth: 1024
---

# **Passkeys, en pratique**

<br>
<br>

### Daniel Garnier-Moiroux

Paris Web, 2025-09-25


---
layout: image-right
image: /daniel-intro.jpg
class: smaller
---

#### Daniel
### Garnier-Moiroux
<br>

Software Engineer

- <logos-spring-icon /> Spring
- <logos-bluesky /> @garnier.wf
- <logos-firefox /> https://garnier.wf/
- <logos-github-icon /> github.com/Kehrlann/
- <fluent-emoji-flat-envelope-with-arrow /> contact@garnier.wf

---
layout: image-right
image: passwords.jpg
---

# **Mots de passe: c'est la cata!**

&nbsp;

On est en 2025, pas besoin de vous convaincre...

---
layout: center
---

# Les **passkeys**, c'est quoi ce truc?

---
class: smaller
---

# Glossaire

- 🔑 **Passkey**
    - Un _identifiant cryptographique_, lié à un compte sur un site
- 📱 **Authenticator**
    - _Une entité cryptographique, hardwarde ou software_ : l'objet ou le programme que vous utilisez pour vous identifier
- 🐶 **FIDO (2)**: **F**ast **ID**entity **O**nline
    - Deux specs: WebAuthN (web) + CTAP (authenticator)
    - FIDO alliance: Apple, Google, Microsoft, _[et bien plus encore](https://fidoalliance.org/members/)_
- 🌍 **WebAuthN**
    - [Spécification W3C](https://www.w3.org/TR/webauthn-3/) -> le JS dans votre navigateur

---
layout: two-cols-header
---

## Comment ça marche?

Grâce à de la *cryptographie asymétrique*,

càd une paire de clefs [privée + publique]

::left::

<div v-click>

### 🛂📒 *Registration*

Générer une clef, pour une *origin*
<br>
(~ par nom de domaine)
<br>
Enregistrer clef privée, partager clef publique

</div>

::right::

<div v-click>

### 🔓🔑 *Authentication*

Prouver son identité via la clef privée

</div>

---
layout: image
image: /passkeys-french-1.png
---

---
layout: image
image: /passkeys-french-3.png
---

---
layout: image
image: /passkeys-french-2.png
---

---

# Les passkeys, PAS de la biométrie!

<br>

<img src="/passkeys-french-biometrics-1.png" style="width: 100%;"/>

---

# Les passkeys, PAS de la biométrie!

<br>

<img src="/passkeys-french-biometrics-2.png" style="width: 100%;"/>

---

# Les passkeys, PAS de la biométrie!

<br>

<img src="/passkeys-french-biometrics-3.png" style="width: 100%;"/>

---

# Les passkeys, PAS de la biométrie!

<br>

<img src="/passkeys-french-biometrics-4.png" style="width: 100%;"/>

---
layout: center
---

# ~~ Du code

<img src="/lets-code.gif" style="height: 400px"/>

---

# Observations

- 🤯 C'est Compliqué™
    - Si possible, laissez votre "identity provider" gérer
- 👷 Utilisez une lib (c'est _quand même_ compliqué)
- 🍃 Support dans Spring
    - Contribuez! https://github.com/spring-projects/spring-security
- 📚 Plein de lecture!
    - 🥇 https://developers.yubico.com/

---

## Références

<br>

https://github.com/Kehrlann/spring-security-passkeys-sample

<!-- qrencode -s9 -m 2 -o slides/public/qr-code-paris-web.png https://openfeedback.io/mATeVNzPiyOWyDiT8VdN/null/pPJEYwl4Mnn1IgzyRnVj  -->
<div style="float:right; margin-right: 50px; text-align: center;">
  <a href="https://openfeedback.io/mATeVNzPiyOWyDiT8VdN/null/pPJEYwl4Mnn1IgzyRnVj" target="_blank">
      <img src="/qr-code-paris-web.png" style="margin-bottom: -45px; margin-top: -15px;" >
  </a>
</div>

<br>

- <logos-bluesky /> @garnier.wf
- <logos-firefox /> https://garnier.wf/
- <fluent-emoji-flat-envelope-with-arrow /> contact@garnier.wf


---
layout: image
hideInToc: true
image: /meet-me.jpg
class: end
---

# **Merci 😊**

