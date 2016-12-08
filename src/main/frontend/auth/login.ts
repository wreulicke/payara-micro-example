export interface LoginInfo {
  name: string,
  password: string,
}

export async function login(o: LoginInfo) {
  const Response = await fetch("http://localhost:8080/api/example/login", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    credentials: "include",
    body: JSON.stringify(o),
  })
  return Response.json()
}
