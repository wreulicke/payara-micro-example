export default async function tasks() {
  const response = await fetch("http://localhost:8080/api/example/task", {
    method: "GET",
    headers: {
      "content-type": "application/json",
    },
    credentials: "include",
  })
  return response.json()
}