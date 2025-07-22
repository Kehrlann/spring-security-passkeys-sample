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
    - [Spécification W3C](https://www.w3.org/TR/webauthn-3/) -> le Javascript dans votre navigateur

---
layout: two-cols-header
---

## How does it work?

Using *asymmetric cryptography*,

i.e. [private + public] key pair

::left::

<div v-click>

### 🛂📒 Registration

Generate key pair, per *origin*
<br>
(~ per domain name)
<br>
Save private key, share public key

</div>

::right::

<div v-click>

### 🔓🔑 Authentication

Use private key to prove identity

</div>


---
layout: image
image: /passkeys-registration-08.png
---

---
layout: image
image: /passkeys-registration-code.png
---


---

# Passkeys are NOT biometric!

<br>

<img src="/passkeys-private-keys-1.png" style="width: 100%;"/>

---

# Passkeys are NOT biometric!

<br>

<img src="/passkeys-private-keys-2.png" style="width: 100%;"/>

---

# Passkeys are NOT biometric!

<br>

<img src="/passkeys-private-keys-3.png" style="width: 100%;"/>

---

# Passkeys are NOT biometric!

<br>

<img src="/passkeys-private-keys-4.png" style="width: 100%;"/>

---
layout: center
---

# ~~ Let's code!

<img src="/lets-code.gif" style="height: 400px"/>

---

## Spring Security classes

<br>

<img src="/spring-security-classes-tables.png" style="height: 400px; margin:auto;"/>


---

# Observations

- 🤯 It's Complicated™
    - If possible: let your Identity Provider handle it
- 👷 Use a library (It's _still_ complicated)
- 🍃 Spring Security support
    - JDBC implementations coming in 6.5 (May 2025)
    - Contribute: https://github.com/spring-projects/spring-security
- 📚 Read up!
    - 🥇 https://developers.yubico.com/

---

## References

<br>

https://github.com/Kehrlann/spring-security-passkeys-sample

<!-- https://mobile.devoxx.com/events/vdt25/rate-talk/2789 -->
<div style="float:right; margin-right: 50px; text-align: center;">
  <img src="/qr-code.png" style="margin-bottom: -45px; margin-top: -15px;" >
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

