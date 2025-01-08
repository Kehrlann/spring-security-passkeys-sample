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

Voxxed Ticino, 2025-01-17


---
layout: image-right
image: /daniel-intro.jpg
class: smaller
---

#### Daniel
### Garnier-Moiroux
<br>

Software Engineer @ Broadcom

- <logos-spring-icon /> Spring + Tanzu
- <logos-bluesky /> @garnier.wf
- <logos-firefox /> https://garnier.wf/
- <logos-github-icon /> github.com/Kehrlann/
- <fluent-emoji-flat-envelope-with-arrow /> contact@garnier.wf

---
layout: center
---

# What is this **WebAuthN** thing?

---
class: smaller
---

# Glossary

- 🌍 **WebAuthN**
    - [W3C spec](https://www.w3.org/TR/webauthn-3/) -> Javascript in your browser
- 📱 **Authenticator**
    - _A cryptographic entity, hardware or software_ -> thing you use to authenticate
- 🔑 **Passkey**
    - A _discoverable_ WebAuthN authenticator
- 🐶 **FIDO2**
    - WebAuthN + CTAP
    - FIDO alliance: Apple, Google, Microsoft

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

## Example: registration

<br>

<img src="/webauthn-registration-flow-01.svg" />

---
layout: image
image: /webauthn-registration-1.png
---

---
layout: image
image: /webauthn-registration-2.png
---

---
layout: image
image: /webauthn-registration-3.png
---

---
layout: image
image: /webauthn-registration-4.png
---

---
layout: image
image: /webauthn-registration-5.png
---

---
layout: image
image: /webauthn-registration-6.png
---

---
layout: center
---

# ~~ Let's code!

<img src="/lets-code.gif" style="height: 400px"/>


---
layout: image
image: /fido-attestation-structures.svg
---

---

# Observations

- 🤯 It's Complicated™
- 👷 Use a library
    - (It's _still_ complicated)
- 🤔 Define your use-case(s)
- 📚 Read up!
    - Yubico's site is a gold mine
- 🍃🔐 Coming Soon™ in Spring Security

---

## References

<br>

### https://github.com/Kehrlann/spring-webauthn

<!-- ouch the hack -->
<div style="float:right; margin-right: 50px; text-align: center;">
  <img src="/qr-code.png" style="margin-bottom: -45px; margin-top: -15px;" >
</div>

<br>

- <logos-mastodon-icon /> @Kehrlann@hachyderm.io
- <logos-twitter /> @Kehrlann
- <logos-firefox /> https://garnier.wf/
- <fluent-emoji-flat-envelope-with-arrow /> daniel.garnier-moiroux@broadcom.com


---
layout: image
hideInToc: true
image: /meet-me.jpg
class: end
---

# **Merci 😊**

