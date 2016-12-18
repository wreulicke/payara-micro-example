export interface Task {
  name: string
  parent?: number
}
export default async function login(task: Task) {
  const response = await fetch("http://localhost:8080/api/example/addTask", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    credentials: "include",
    body: JSON.stringify(task),
  })
  return response.json()
}