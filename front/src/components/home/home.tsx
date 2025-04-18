import { useAuth } from "@/context/AuthContext"

export function HomePage() {

    const { userName } = useAuth();

    return (
        <div className="min-h-screen bg-white flex-col items-center justify-center p-4">
            <header className="mb-8">
                <h1 className="text-4xl font-bold text-primary mb-2 text-left">
                    Hello, {userName}
                </h1>
                <span><button className="outline-2 rounded-lg p-1">
                    New Post
                </button></span>
            </header>
        </div>
    )
}
