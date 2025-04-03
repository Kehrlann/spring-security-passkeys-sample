#!/usr/bin/env bash

# generate key

#KEY_NAME=example
#openssl ecparam -name secp256k1 -genkey -noout -out "$KEYNAME-private.pem"
#openssl ec -in "$KEYNAME-private.pem" -pubout > "$KEYNAME-public.pem"

# Sign something with the key
SIGN_THIS="{\"some\": \"json\", \"id\": 42}"
openssl dgst -sha256 -sign one-private.pem <<< "$SIGN_THIS" > signature.bin

echo "Signature, base64 encoded:"
base64 -i signature.bin

# Verify the signature
echo ""
openssl dgst -sha256 -verify one-public.pem -signature signature.bin <<< "$SIGN_THIS"
