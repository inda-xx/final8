from openai import OpenAI
import os

# Path for the task file
task_file_path = os.path.join("tasks", "new_task.md")

def generate_image_url_from_description(description, client):
    # Build a more descriptive prompt for DALL-E based on the task details
    prompt = (
        f"Create an illustration for a programming task based on the following theme:\n\n"
        f"Theme: {description[:200]}...\n\n"  # Include a snippet of the description as a theme
        "The illustration should capture the key elements of this task, which involves programming concepts. "
        "Make it visually engaging and clear, with an emphasis on learning and creativity.\n\n"
        "Make sure the image is clear, modern, and professional, suitable as an educational feature in a programming context."
    )

    # Generate image using DALL-E 3
    response = client.images.generate(
        model="dall-e-3",
        prompt=prompt,
        size="1792x1024",
        quality="standard",
        n=1,
    )

    # Get the URL of the generated image
    image_url = response.data[0].url
    return image_url


def insert_image_url_into_markdown(image_url, markdown_path):
    # Read the existing task description and add the image URL at the top
    with open(markdown_path, "r") as f:
        markdown_content = f.read()
    image_markdown = f"![Task Image]({image_url})\n\n"
    new_markdown_content = image_markdown + markdown_content

    # Write the updated content back to the markdown file
    with open(markdown_path, "w") as f:
        f.write(new_markdown_content)

def main(api_key):
    client = OpenAI(api_key=api_key)

    # Read the task description from the markdown file
    with open(task_file_path, "r") as f:
        task_description = f.read()

    # Generate the image URL and add it to the markdown file
    image_url = generate_image_url_from_description(task_description, client)
    insert_image_url_into_markdown(image_url, task_file_path)
    print("Image URL generated and added to the task file.")

if __name__ == "__main__":
    # Ensure the OpenAI API key is provided as an environment variable
    api_key = os.getenv("OPENAI_API_KEY")
    if not api_key:
        print("Error: OpenAI API key not found.")
    else:
        main(api_key)
