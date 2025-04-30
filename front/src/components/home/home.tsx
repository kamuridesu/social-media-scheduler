import { useAuth } from "@/context/AuthContext";

function Header({ userName }: string) {
  return (
    <div className="min-h-screen bg-white flex-col items-center justify-between p-4">
      <header className="mb-8 flex justify-between items-center w-full">
        <h1 className="text-4xl font-bold text-primary mb-2 text-left">
          Hello, {userName}
        </h1>
        <span>
          <button className="outline-2 rounded-lg px-6 py-3 text-lg ml-auto">
            New Post
          </button>
        </span>
      </header>
    </div>
  );
}

function Body() {
  return (
    <div className="flex gap-6 w-full">
      <div className="flex-1 flex flex-col gap-4">
        <input
          type="text"
          placeholder="Search..."
          className="border border-gray-300 rounded-lg px-4 py-2"
        />
      </div>

      <div className="flex gap-2">
        <button className="bg-gray-100 px-3 py-1 rounded-full">Filter</button>
      </div>

      <div className="grid grid-cols-1 gap-4">
        <div className="border rounded-lg p-4 shadow">
          <h2 className="font-semibold text-lg mb-2">Title</h2>
          <p>Content</p>
        </div>
      </div>

      <div className="w-64 border rounded-lg p-4 shadow bg-gray-50">
        <h3 className="text-xl font-semibold mb-3">Linked Accounts</h3>
        <ul className="space-y-2">
          <li className="text-blue-600 underline cursor-pointer">Github</li>
        </ul>
      </div>
    </div>
  );
}

export function HomePage() {
  const { userName } = useAuth();
  return (
    <>
      <Header userName={userName}></Header>
      <Body />
    </>
  );
}
