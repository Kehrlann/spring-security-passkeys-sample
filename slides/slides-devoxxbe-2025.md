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

# **Passkeys in practice**
## Implementing passwordless apps

<br>
<br>

### Daniel Garnier-Moiroux

Devoxx BE, 2025-10-09


---
layout: image-right
image: /daniel-intro-hat.jpg
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

# **Passwords are terrible**

&nbsp;

In 2025, you don't need convincing!

---

# One-Time Tokens

<br>

Implementing password-less apps ...

<v-click>

&nbsp;

&nbsp;

## _... like it's 1998!_ 🪩💃🕺


</v-click>

---
layout: center
---

# What is this **passkeys** thing?

---
class: smaller
---

# Glossary

- 🔑 **Passkey**
    - A _cryptographic credential_, tied to an account on a website/app
- 📱 **Authenticator**
    - _A cryptographic entity, hardware or software_ : the thing you use to authenticate
- 🐶 **FIDO2**
    - WebAuthN + CTAP
    - FIDO alliance: Apple, Google, Microsoft, [many many more](https://fidoalliance.org/members/)
- 🌍 **WebAuthN**
    - [W3C spec](https://www.w3.org/TR/webauthn-3/) -> Javascript in your browser

---
layout: two-cols-header
---

## How does it work?

<div v-click>

Using *asymmetric cryptography*,

i.e. [private + public] key pair

</div>

---
layout: image
image: /asymmetric-crypto-1.png
---

---
layout: image
image: /asymmetric-crypto-2.png
---

---
layout: image
image: /asymmetric-crypto-3.png
---

---
layout: image
image: /asymmetric-crypto-4.png
---

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
layout: cover
class: smaller
---

# Passkey **Registration**

---

<img src="/webauthn-registration-flow-01.svg" />

---
layout: image
image: /passkeys-registration-01.png
---

---
layout: image
image: /passkeys-registration-02.png
---

---
layout: image
image: /passkeys-registration-03.png
---

---
layout: image
image: /passkeys-registration-04.png
---

---
layout: image
image: /passkeys-registration-05.png
---

---
layout: image
image: /passkeys-registration-06.png
---

---
layout: image
image: /passkeys-registration-07.png
---

---
layout: image
image: /passkeys-registration-08.png
---

---
layout: image
image: /passkeys-registration-code.png
---

---
layout: cover
class: smaller
---

# Passkey **Authentication**

---
layout: image
image: /passkeys-authentication.png
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
layout: image
image: /fido-attestation-structures.svg
---

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

<!-- qrencode -s 9 -m 2 -o public/qr-code-devoxxbe-2025.png https://m.devoxx.com/events/dvbe25/talks/6227/passkeys-onetime-tokens-passwordless-spring-security -->
<div style="float:right; margin-right: 50px; text-align: center;">
  <a
  href="https://m.devoxx.com/events/dvbe25/talks/6227/passkeys-onetime-tokens-passwordless-spring-security" target="_blank">
      <img src="/qr-code-devoxxbe-2025.png" style="margin-bottom: -45px; margin-top: -15px; height:300px;" >
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

