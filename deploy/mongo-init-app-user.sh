#!/usr/bin/env bash
set -Eeuo pipefail

: "${MONGO_INITDB_DATABASE:?MONGO_INITDB_DATABASE is required}"
: "${MONGO_APP_USER:?MONGO_APP_USER is required}"
: "${MONGO_APP_PASS:?MONGO_APP_PASS is required}"

"${mongo[@]}" "$MONGO_INITDB_DATABASE" <<-EOJS
	db.createUser({
		user: $(_js_escape "$MONGO_APP_USER"),
		pwd: $(_js_escape "$MONGO_APP_PASS"),
		roles: [
			{ role: 'readWrite', db: $(_js_escape "$MONGO_INITDB_DATABASE") }
		]
	})
EOJS
