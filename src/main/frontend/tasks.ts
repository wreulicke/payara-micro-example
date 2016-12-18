const tasks = [
  {
    id: 1,
    name: "My Tree",
  },
  {
    name: "hello",
    id: 2,
    parent: 1,
  },
  {
    name: "wat",
    id: 3,
    parent: 1,
  },
  {
    id: 4,
    name: "child folder",
    parent: 1,
  },
  {
    id: 5,
    name: "child folder",
    parent: 4,
  },
  {
    name: "hello",
    id: 6,
    parent: 5,
  },
  {
    name: "wat",
    id: 7,
    parent: 5,
  },
  {
    name: "hello",
    id: 8,
    parent: 4,
  },
  {
    name: "wat",
    id: 9,
    parent: 4,
  },
  {
    id: 10,
    name: "child folder",
    parent: 4,
  },
  {
    name: "hello",
    id: 11,
    parent: 10,
  },
  {
    name: "wat",
    id: 12,
    parent: 10,
  },
  {
    name: "wat",
    id: 13,
  },
]

export default tasks